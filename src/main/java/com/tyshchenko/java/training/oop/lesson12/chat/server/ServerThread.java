package com.tyshchenko.java.training.oop.lesson12.chat.server;

import com.tyshchenko.java.training.oop.lesson12.chat.common.Message;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Alexander Tyshchenko.
 */
public class ServerThread implements Runnable {

    private static final int maxClients = 50;
    private ClientThread clients[];
    private ServerSocket socket = null;
    private Thread thread = null;
    private int clientCount = 0;
    private int port = 9999;
    private ServerChatForm serverChatForm;
    private Database database;

    public ServerThread(ServerChatForm serverChatForm) {

        clients = new ClientThread[maxClients];
        this.serverChatForm = serverChatForm;
        database = new Database(serverChatForm.getFilePath());

        try {
            socket = new ServerSocket(port);
            port = socket.getLocalPort();
            serverChatForm.getTextArea().append("Server started. IP : " + InetAddress.getLocalHost() + ", Port : " + socket.getLocalPort());
            thread = new Thread(this);
            thread.start();
        } catch (IOException ioe) {
            serverChatForm.getTextArea().append("Can not bind to port : " + port + "\nRetrying");
            serverChatForm.retryStart(0);
        }
    }

    public ServerThread(ServerChatForm serverChatForm, int port) {

        clients = new ClientThread[maxClients];
        this.serverChatForm = serverChatForm;
        this.port = port;
        database = new Database(serverChatForm.getFilePath());

        try {
            socket = new ServerSocket(this.port);
            this.port = socket.getLocalPort();
            serverChatForm.getTextArea().append("Server started. IP : " + InetAddress.getLocalHost() + ", port : " + socket.getLocalPort());
            start();
        } catch (IOException ioe) {
            serverChatForm.getTextArea().append("\nCan not bind to port " + this.port + ": " + ioe.getMessage());
            serverChatForm.retryStart(0);
        }
    }

    public void run() {
        while (!thread.isInterrupted()) {
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

    private int findClient(int userId) {
        for (int i = 0; i < clientCount; i++) {
            if (clients[i].getUserId() == userId) {
                return i;
            }
        }
        return -1;
    }

    public synchronized void handle(int ID, Message message) {
        if (message.content != null && message.content.equals(".bye")) {
            announce(Message.Type.SIGN_OUT, "SERVER", message.sender);
            remove(ID);
        } else {

            switch (message.type) {
                case LOGIN: {
                    if (findUserThread(message.sender) == null) {
//                    if (database.checkLogin(message.sender, message.content)) {
                        clients[findClient(ID)].username = message.sender;
                        clients[findClient(ID)].send(new Message(Message.Type.LOGIN, "SERVER", "TRUE", message.sender));
                        announce(Message.Type.NEW_USER, "SERVER", message.sender);
                        sendUserList(message.sender);
//                    } else {
//                        clients[findClient(userId)].send(new Message("login", "SERVER", "FALSE", message.sender));
//                    }
                    } else {
                        clients[findClient(ID)].send(new Message(Message.Type.LOGIN, "SERVER", "FALSE", message.sender));
                    }
                    break;
                }
                case MESSAGE: {
                    if (message.recipient.equals("All")) {
                        announce(Message.Type.MESSAGE, message.sender, message.content);
                    } else {
                        findUserThread(message.recipient).send(new Message(message.type, message.sender, message.content, message.recipient));
                        clients[findClient(ID)].send(new Message(message.type, message.sender, message.content, message.recipient));
                    }
                    break;
                }
                case PING: {
                    clients[findClient(ID)].send(new Message(Message.Type.PING, "SERVER", "OK", message.sender));
                    break;
                }
                case SIGN_UP: {
                    if (findUserThread(message.sender) == null) {
//                        if (!database.userExists(message.sender)) {
                            database.addUser(message.sender, message.content);
                            clients[findClient(ID)].username = message.sender;
                            clients[findClient(ID)].send(new Message(Message.Type.SIGN_UP, "SERVER", "TRUE", message.sender));
                            clients[findClient(ID)].send(new Message(Message.Type.LOGIN, "SERVER", "TRUE", message.sender));
                            announce(Message.Type.NEW_USER, "SERVER", message.sender);
                            sendUserList(message.sender);
//                        } else {
//                            clients[findClient(userId)].send(new Message(Message.Type.SIGN_UP, "SERVER", "FALSE", message.sender));
//                        }
                    } else {
                        clients[findClient(ID)].send(new Message(Message.Type.SIGN_UP, "SERVER", "FALSE", message.sender));
                    }
                    break;
                }
                case UPLOAD_REQUEST: {
                    if (message.recipient.equals("All")) {
                        clients[findClient(ID)].send(new Message(Message.Type.MESSAGE, "SERVER", "Uploading to 'All' forbidden", message.sender));
                    } else {
                        findUserThread(message.recipient).send(new Message(Message.Type.UPLOAD_REQUEST, message.sender, message.content, message.recipient));
                    }
                    break;
                }
                case UPLOAD_RESPONSE: {
                    if (!message.content.equals("NO")) {
                        String IP = findUserThread(message.sender).socket.getInetAddress().getHostAddress();
                        findUserThread(message.recipient).send(new Message(Message.Type.UPLOAD_RESPONSE, IP, message.content, message.recipient));
                    } else {
                        findUserThread(message.recipient).send(new Message(Message.Type.UPLOAD_RESPONSE, message.sender, message.content, message.recipient));
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

    public ClientThread findUserThread(String userName) {
        for (int i = 0; i < clientCount; i++) {
            if (clients[i].username.equals(userName)) {
                return clients[i];
            }
        }
        return null;
    }

    public synchronized void remove(int userId) {
        int pos = findClient(userId);
        if (pos >= 0) {
            ClientThread client = clients[pos];
            serverChatForm.getTextArea().append("\nRemoving client thread " + userId + " at " + pos);
            if (pos < clientCount - 1) {
                for (int i = pos + 1; i < clientCount; i++) {
                    clients[i - 1] = clients[i];
                }
            }
            clientCount--;
            try {
                client.close();
            } catch (IOException ioe) {
                serverChatForm.getTextArea().append("\nError closing thread: " + ioe);
            }
        }
    }

    private void addThread(Socket socket) {
        if (clientCount < clients.length) {
            serverChatForm.getTextArea().append("\nClient accepted: " + socket);
            clients[clientCount] = new ClientThread(this, socket);
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
