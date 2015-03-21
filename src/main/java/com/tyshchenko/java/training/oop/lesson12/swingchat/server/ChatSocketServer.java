package com.tyshchenko.java.training.oop.lesson12.swingchat.server;

import com.tyshchenko.java.training.oop.lesson12.swingchat.common.Message;
import com.tyshchenko.java.training.oop.lesson4.interfaces.Showable;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Alexander Tyshchenko.
 */
public class ChatSocketServer implements Runnable {

    private ServerThread clients[];
    private ServerSocket socket = null;
    private Thread thread = null;
    private int clientCount = 0;
    private int port = 13000;
    private ServerChatForm serverChatForm;
    private Database db;

    public ChatSocketServer(ServerChatForm serverChatForm) {

        clients = new ServerThread[50];
        this.serverChatForm = serverChatForm;
        db = new Database(serverChatForm.getFilePath());

        try {
            socket = new ServerSocket(port);
            port = socket.getLocalPort();
            serverChatForm.getTextArea().append("Server started. IP : " + InetAddress.getLocalHost() + ", Port : " + socket.getLocalPort());
            start();
        } catch (IOException ioe) {
            serverChatForm.getTextArea().append("Can not bind to port : " + port + "\nRetrying");
            serverChatForm.retryStart(0);
        }
    }

    public ChatSocketServer(ServerChatForm serverChatForm, int port) {

        clients = new ServerThread[50];
        this.serverChatForm = serverChatForm;
        this.port = port;
        db = new Database(serverChatForm.getFilePath());

        try {
            socket = new ServerSocket(this.port);
            this.port = socket.getLocalPort();
            serverChatForm.getTextArea().append("Server started. IP : " + InetAddress.getLocalHost() + ", port : " + socket.getLocalPort());
            start();
        } catch (IOException ioe) {
            serverChatForm.getTextArea().append("\nCan not bind to port " + this.port + ": " + ioe.getMessage());
        }
    }

    public void run() {
        while (thread != null) {
            try {
                serverChatForm.getTextArea().append("\nWaiting for a client ...");
                addThread(socket.accept());
            } catch (Exception ioe) {
                serverChatForm.getTextArea().append("\nServer accept error: \n");
                serverChatForm.retryStart(0);
            }
        }
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    public void stop() {
        if (thread != null) {
            thread.interrupt();
            thread = null;
        }
    }

    private int findClient(int ID) {
        for (int i = 0; i < clientCount; i++) {
            if (clients[i].getID() == ID) {
                return i;
            }
        }
        return -1;
    }

    public synchronized void handle(int ID, Message msg) {
        if (msg.content != null && msg.content.equals(".bye")) {
            announce(Message.Type.SIGN_OUT, "SERVER", msg.sender);
            remove(ID);
        } else {

            switch (msg.type) {
                case LOGIN: {
                    if (findUserThread(msg.sender) == null) {
//                    if (db.checkLogin(msg.sender, msg.content)) {
                        clients[findClient(ID)].username = msg.sender;
                        clients[findClient(ID)].send(new Message(Message.Type.LOGIN, "SERVER", "TRUE", msg.sender));
                        announce(Message.Type.NEW_USER, "SERVER", msg.sender);
                        sendUserList(msg.sender);
//                    } else {
//                        clients[findClient(ID)].send(new Message("login", "SERVER", "FALSE", msg.sender));
//                    }
                    } else {
                        clients[findClient(ID)].send(new Message(Message.Type.LOGIN, "SERVER", "FALSE", msg.sender));
                    }
                    break;
                }
                case MESSAGE: {
                    if (msg.recipient.equals("All")) {
                        announce(Message.Type.MESSAGE, msg.sender, msg.content);
                    } else {
                        findUserThread(msg.recipient).send(new Message(msg.type, msg.sender, msg.content, msg.recipient));
                        clients[findClient(ID)].send(new Message(msg.type, msg.sender, msg.content, msg.recipient));
                    }
                    break;
                }
                case PING: {
                    clients[findClient(ID)].send(new Message(Message.Type.PING, "SERVER", "OK", msg.sender));
                    break;
                }
                case SIGN_UP: {
                    if (findUserThread(msg.sender) == null) {
                        if (!db.userExists(msg.sender)) {
                            db.addUser(msg.sender, msg.content);
                            clients[findClient(ID)].username = msg.sender;
                            clients[findClient(ID)].send(new Message(Message.Type.SIGN_UP, "SERVER", "TRUE", msg.sender));
                            clients[findClient(ID)].send(new Message(Message.Type.LOGIN, "SERVER", "TRUE", msg.sender));
                            announce(Message.Type.NEW_USER, "SERVER", msg.sender);
                            sendUserList(msg.sender);
                        } else {
                            clients[findClient(ID)].send(new Message(Message.Type.SIGN_UP, "SERVER", "FALSE", msg.sender));
                        }
                    } else {
                        clients[findClient(ID)].send(new Message(Message.Type.SIGN_UP, "SERVER", "FALSE", msg.sender));
                    }
                    break;
                }
                case UPLOAD_REQUEST: {
                    if (msg.recipient.equals("All")) {
                        clients[findClient(ID)].send(new Message(Message.Type.MESSAGE, "SERVER", "Uploading to 'All' forbidden", msg.sender));
                    } else {
                        findUserThread(msg.recipient).send(new Message(Message.Type.UPLOAD_REQUEST, msg.sender, msg.content, msg.recipient));
                    }
                    break;
                }
                case UPLOAD_RESPONSE: {
                    if (!msg.content.equals("NO")) {
                        String IP = findUserThread(msg.sender).socket.getInetAddress().getHostAddress();
                        findUserThread(msg.recipient).send(new Message(Message.Type.UPLOAD_RESPONSE, IP, msg.content, msg.recipient));
                    } else {
                        findUserThread(msg.recipient).send(new Message(Message.Type.UPLOAD_RESPONSE, msg.sender, msg.content, msg.recipient));
                    }
                    break;
                }
            }
        }
    }

    public void announce(Message.Type type, String sender, String content) {
        Message msg = new Message(type, sender, content, "All");
        for (int i = 0; i < clientCount; i++) {
            clients[i].send(msg);
        }
    }

    public void sendUserList(String toWhom) {
        for (int i = 0; i < clientCount; i++) {
            findUserThread(toWhom).send(new Message(Message.Type.NEW_USER, "SERVER", clients[i].username, toWhom));
        }
    }

    public ServerThread findUserThread(String usr) {
        for (int i = 0; i < clientCount; i++) {
            if (clients[i].username.equals(usr)) {
                return clients[i];
            }
        }
        return null;
    }

    public synchronized void remove(int ID) {
        int pos = findClient(ID);
        if (pos >= 0) {
            ServerThread toTerminate = clients[pos];
            serverChatForm.getTextArea().append("\nRemoving client thread " + ID + " at " + pos);
            if (pos < clientCount - 1) {
                for (int i = pos + 1; i < clientCount; i++) {
                    clients[i - 1] = clients[i];
                }
            }
            clientCount--;
            try {
                toTerminate.close();
            } catch (IOException ioe) {
                serverChatForm.getTextArea().append("\nError closing thread: " + ioe);
            }
        }
    }

    private void addThread(Socket socket) {
        if (clientCount < clients.length) {
            serverChatForm.getTextArea().append("\nClient accepted: " + socket);
            clients[clientCount] = new ServerThread(this, socket);
            try {
                clients[clientCount].open();
                clients[clientCount].start();
                clientCount++;
            } catch (IOException ioe) {
                serverChatForm.getTextArea().append("\nError opening thread: " + ioe);
            }
        } else {
            serverChatForm.getTextArea().append("\nClient refused: maximum " + clients.length + " reached.");
        }
    }

    public ServerChatForm getServerChatForm() {
        return serverChatForm;
    }
}
