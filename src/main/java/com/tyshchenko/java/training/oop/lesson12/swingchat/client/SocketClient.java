package com.tyshchenko.java.training.oop.lesson12.swingchat.client;

import com.tyshchenko.java.training.oop.lesson12.swingchat.common.Message;
import com.tyshchenko.java.training.oop.lesson12.swingchat.common.Message.Type;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;

/**
 * @author Alexander Tyshchenko.
 */
public class SocketClient implements Runnable {

    private int port;
    private String serverAddress;
    private Socket socket;
    private ClientChatForm clientChatForm;
    private ObjectInputStream socketInputStream;
    private ObjectOutputStream socketOutputStream;
    private History history;

    public SocketClient(ClientChatForm frame) throws IOException {
        this.clientChatForm = frame;
        this.serverAddress = clientChatForm.getServerAddress();
        this.port = clientChatForm.getPort();
        socket = new Socket(InetAddress.getByName(serverAddress), port);

        socketOutputStream = new ObjectOutputStream(socket.getOutputStream());
        socketOutputStream.flush();
        socketInputStream = new ObjectInputStream(socket.getInputStream());

        history = clientChatForm.getHist();
    }

    @Override
    public void run() {
        boolean keepRunning = true;
        while (keepRunning) {
            try {
                Message msg = (Message) socketInputStream.readObject();
                System.out.println("Incoming : " + msg.toString());

                switch (msg.type) {
                    case MESSAGE: {
                        if (msg.recipient.equals(clientChatForm.getUsername())) {
                            clientChatForm.getClientArea().append("[" + msg.sender + " > Me] : " + msg.content + "\n");
                        } else {
                            clientChatForm.getClientArea().append("[" + msg.sender + " > " + msg.recipient + "] : " + msg.content + "\n");
                        }

                        if (!msg.content.equals(".bye") && !msg.sender.equals(clientChatForm.getUsername())) {
                            String msgTime = (new Date()).toString();

                            try {
                                history.addMessage(msg, msgTime);
                                DefaultTableModel table = (DefaultTableModel) clientChatForm.getHistoryFrame().getHistoryTable().getModel();
                                table.addRow(new Object[]{msg.sender, msg.content, "Me", msgTime});
                            } catch (Exception ex) {
                            }
                        }
                        break;
                    }
                    case LOGIN: {
                        if (msg.content.equals("TRUE")) {
                            clientChatForm.getButtonLogin().setEnabled(false);
                            clientChatForm.getButtonSignUp().setEnabled(true);
                            clientChatForm.getButtonSendMessage().setEnabled(true);
                            clientChatForm.getTextFieldMessage().setEnabled(true);
                            clientChatForm.getClientArea().append("[SERVER > Me] : Login Successful\n");
                            clientChatForm.getTextFieldUsername().setEnabled(false);
                            clientChatForm.getTextFieldPassword().setEnabled(false);
                        } else {
                            clientChatForm.getClientArea().append("[SERVER > Me] : Login Failed\n");
                        }
                        break;
                    }
                    case PING: {
                        clientChatForm.getButtonConnect().setEnabled(false);
                        clientChatForm.getButtonLogin().setEnabled(true);
                        clientChatForm.getButtonSignUp().setEnabled(true);
                        clientChatForm.getTextFieldUsername().setEnabled(true);
                        clientChatForm.getTextFieldPassword().setEnabled(true);
                        clientChatForm.getTextFieldHostAddress().setEditable(false);
                        clientChatForm.getTextFieldHostPort().setEditable(false);
                        clientChatForm.getButtonBrowseHistory().setEnabled(true);
                        clientChatForm.getClientArea().append("[SERVER > Me] : Test connection successful\n");
                        break;
                    }
                    case NEW_USER: {
                        if (!msg.content.equals(clientChatForm.getUsername())) {
                            boolean exists = false;
                            for (int i = 0; i < clientChatForm.getUserListModel().getSize(); i++) {
                                if (clientChatForm.getUserListModel().getElementAt(i).equals(msg.content)) {
                                    exists = true;
                                    break;
                                }
                            }
                            if (!exists) {
                                clientChatForm.getUserListModel().addElement(msg.content);
                            }
                        }
                        break;
                    }
                    case SIGN_UP: {
                        if (msg.content.equals("TRUE")) {
                            clientChatForm.getButtonLogin().setEnabled(false);
                            clientChatForm.getButtonSignUp().setEnabled(false);
                            clientChatForm.getButtonSendMessage().setEnabled(true);
//                        clientChatForm.button3.setEnabled(true);
                            clientChatForm.getClientArea().append("[SERVER > Me] : Singup Successful\n");
                        } else {
                            clientChatForm.getClientArea().append("[SERVER > Me] : Signup Failed\n");
                        }
                        break;
                    }
                    case SIGN_OUT: {
                        if (msg.content.equals(clientChatForm.getUsername())) {
                            clientChatForm.getClientArea().append("[" + msg.sender + " > Me] : Bye\n");
                            clientChatForm.getButtonConnect().setEnabled(true);
                            clientChatForm.getButtonSendMessage().setEnabled(false);
                            clientChatForm.getTextFieldHostAddress().setEditable(true);
                            clientChatForm.getTextFieldHostPort().setEditable(true);

                            for (int i = 1; i < clientChatForm.getUserListModel().size(); i++) {
                                clientChatForm.getUserListModel().removeElementAt(i);
                            }

                            clientChatForm.getClientThread().interrupt();
                        } else {
                            clientChatForm.getUserListModel().removeElement(msg.content);
                            clientChatForm.getClientArea().append("[" + msg.sender + " > All] : " + msg.content + " has signed out\n");
                        }
                        break;
                    }
                    case UPLOAD_REQUEST: {
                        if (JOptionPane.showConfirmDialog(clientChatForm, ("Accept '" + msg.content + "' from " + msg.sender + " ?")) == 0) {

                            JFileChooser jf = new JFileChooser();
                            jf.setSelectedFile(new File(msg.content));
                            int returnVal = jf.showSaveDialog(clientChatForm);

                            String saveTo = jf.getSelectedFile().getPath();
                            if (saveTo != null && returnVal == JFileChooser.APPROVE_OPTION) {
                                Download dwn = new Download(saveTo, clientChatForm);
                                Thread t = new Thread(dwn);
                                t.start();
                                //send(new Message("upload_res", (""+InetAddress.getLocalHost().getHostAddress()), (""+dwn.port), msg.sender));
                                send(new Message(Type.UPLOAD_RESPONSE, clientChatForm.getUsername(), ("" + dwn.getPort()), msg.sender));
                            } else {
                                send(new Message(Type.UPLOAD_RESPONSE, clientChatForm.getUsername(), "NO", msg.sender));
                            }
                        } else {
                            send(new Message(Type.UPLOAD_RESPONSE, clientChatForm.getUsername(), "NO", msg.sender));
                        }
                        break;
                    }
                    case UPLOAD_RESPONSE: {
                        if (!msg.content.equals("NO")) {
                            int port = Integer.parseInt(msg.content);
                            String addr = msg.sender;

//                        clientChatForm.button3.setEnabled(false);
                            clientChatForm.getButtonSendFile().setEnabled(false);
                            Upload upl = new Upload(addr, port, clientChatForm.getFile(), clientChatForm);
                            Thread t = new Thread(upl);
                            t.start();
                        } else {
                            clientChatForm.getClientArea().append("[SERVER > Me] : " + msg.sender + " rejected file request\n");
                        }
                        break;
                    }
                    default: {
                        clientChatForm.getClientArea().append("[SERVER > Me] : Unknown message type\n");
                    }
                }
            } catch (Exception ex) {
                keepRunning = false;
                clientChatForm.getClientArea().append("[Application > Me] : Connection Failure\n");
                clientChatForm.getButtonConnect().setEnabled(true);
                clientChatForm.getTextFieldHostAddress().setEditable(true);
                clientChatForm.getTextFieldHostPort().setEditable(true);
                clientChatForm.getButtonSendMessage().setEnabled(false);
//                clientChatForm.button3.setEnabled(false);
//                clientChatForm.button3.setEnabled(false);

                for (int i = 1; i < clientChatForm.getUserListModel().size(); i++) {
                    clientChatForm.getUserListModel().removeElementAt(i);
                }

                clientChatForm.getClientThread().interrupt();

                System.out.println("Exception SocketClient run()");
                ex.printStackTrace();
            }
        }
    }

    public void send(Message msg) {
        try {
            socketOutputStream.writeObject(msg);
            socketOutputStream.flush();
            System.out.println("Outgoing : " + msg.toString());

            if (msg.type.equals("message") && !msg.content.equals(".bye")) {
                String msgTime = (new Date()).toString();
                try {
                    history.addMessage(msg, msgTime);
                    DefaultTableModel table = (DefaultTableModel) clientChatForm.getHistoryFrame().getHistoryTable().getModel();
                    table.addRow(new Object[]{"Me", msg.content, msg.recipient, msgTime});
                } catch (Exception ex) {
                }
            }
        } catch (IOException ex) {
            System.out.println("Exception SocketClient send()");
        }
    }

    public void closeThread(Thread t) {
        t = null;
    }

}
