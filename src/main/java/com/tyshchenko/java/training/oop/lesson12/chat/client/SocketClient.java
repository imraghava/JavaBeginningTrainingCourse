package com.tyshchenko.java.training.oop.lesson12.chat.client;

import com.tyshchenko.java.training.oop.lesson12.chat.common.Message;
import com.tyshchenko.java.training.oop.lesson12.chat.common.Message.Type;

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
                Message message = (Message) socketInputStream.readObject();
                System.out.println("Incoming : " + message.toString());

                switch (message.type) {
                    case MESSAGE: {
                        if (message.recipient.equals(clientChatForm.getUsername())) {
                            clientChatForm.getClientArea().append("[" + message.sender + " > Me] : " + message.content + "\n");
                        } else {
                            clientChatForm.getClientArea().append("[" + message.sender + " > " + message.recipient + "] : " + message.content + "\n");
                        }

                        if (!message.content.equals(".bye") && !message.sender.equals(clientChatForm.getUsername())) {
                            String msgTime = (new Date()).toString();

                            try {
                                history.addMessage(message, msgTime);
                                DefaultTableModel table = (DefaultTableModel) clientChatForm.getHistoryFrame().getHistoryTable().getModel();
                                table.addRow(new Object[]{
                                        message.sender,
                                        message.content,
                                        "Me",
                                        msgTime});
                            } catch (Exception ex) {
                            }
                        }
                        break;
                    }
                    case LOGIN: {
                        if (message.content.equals("TRUE")) {
                            clientChatForm.getButtonLogin().setEnabled(false);
                            clientChatForm.getButtonSendMessage().setEnabled(true);
                            clientChatForm.getButtonBrowseFile().setEnabled(true);
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
                        clientChatForm.getButtonSignUp().setEnabled(false);
                        clientChatForm.getTextFieldUsername().setEnabled(true);
                        clientChatForm.getTextFieldPassword().setEnabled(true);
                        clientChatForm.getTextFieldHostAddress().setEditable(false);
                        clientChatForm.getTextFieldHostPort().setEditable(false);
                        clientChatForm.getButtonBrowseHistory().setEnabled(true);
                        clientChatForm.getClientArea().append("[SERVER > Me] : Test connection successful\n");
                        break;
                    }
                    case NEW_USER: {
                        if (!message.content.equals(clientChatForm.getUsername())) {
                            boolean exists = false;
                            for (int i = 0; i < clientChatForm.getUserListModel().getSize(); i++) {
                                if (clientChatForm.getUserListModel().getElementAt(i).equals(message.content)) {
                                    exists = true;
                                    break;
                                }
                            }
                            if (!exists) {
                                clientChatForm.getUserListModel().addElement(message.content);
                            }
                        }
                        break;
                    }
                    case SIGN_UP: {
                        if (message.content.equals("TRUE")) {
                            clientChatForm.getButtonLogin().setEnabled(false);
                            clientChatForm.getButtonSignUp().setEnabled(false);
                            clientChatForm.getButtonSendMessage().setEnabled(true);
                            clientChatForm.getClientArea().append("[SERVER > Me] : Singup Successful\n");
                        } else {
                            clientChatForm.getClientArea().append("[SERVER > Me] : Signup Failed\n");
                        }
                        break;
                    }
                    case SIGN_OUT: {
                        if (message.content.equals(clientChatForm.getUsername())) {
                            clientChatForm.getClientArea().append("[" + message.sender + " > Me] : Bye\n");
                            clientChatForm.getButtonConnect().setEnabled(true);
                            clientChatForm.getButtonSendMessage().setEnabled(false);
                            clientChatForm.getTextFieldHostAddress().setEditable(true);
                            clientChatForm.getTextFieldHostPort().setEditable(true);

                            for (int i = 1; i < clientChatForm.getUserListModel().size(); i++) {
                                clientChatForm.getUserListModel().removeElementAt(i);
                            }

                            clientChatForm.getClientThread().interrupt();
                        } else {
                            clientChatForm.getUserListModel().removeElement(message.content);
                            clientChatForm.getClientArea().append("[" + message.sender + " > All] : " + message.content + " has signed out\n");
                        }
                        break;
                    }
                    case UPLOAD_REQUEST: {
                        if (JOptionPane.showConfirmDialog(clientChatForm, ("Accept '" + message.content + "' from " + message.sender + " ?")) == 0) {

                            JFileChooser fileChooser = new JFileChooser();
                            fileChooser.setSelectedFile(new File(message.content));
                            int returnVal = fileChooser.showSaveDialog(clientChatForm);

                            String saveTo = fileChooser.getSelectedFile().getPath();
                            if (saveTo != null && returnVal == JFileChooser.APPROVE_OPTION) {
                                Downloader dwn = new Downloader(saveTo, clientChatForm);
                                Thread downloader = new Thread(dwn);
                                downloader.start();
                                send(new Message(Type.UPLOAD_RESPONSE, clientChatForm.getUsername(), ("" + dwn.getPort()), message.sender));
                            } else {
                                send(new Message(Type.UPLOAD_RESPONSE, clientChatForm.getUsername(), "NO", message.sender));
                            }
                        } else {
                            send(new Message(Type.UPLOAD_RESPONSE, clientChatForm.getUsername(), "NO", message.sender));
                        }
                        break;
                    }
                    case UPLOAD_RESPONSE: {
                        if (!message.content.equals("NO")) {
                            int port = Integer.parseInt(message.content);
                            String address = message.sender;
                            clientChatForm.getButtonSendFile().setEnabled(false);
                            Uploader upl = new Uploader(address, port, clientChatForm.getFile(), clientChatForm);
                            Thread t = new Thread(upl);
                            t.start();
                        } else {
                            clientChatForm.getClientArea().append("[SERVER > Me] : " + message.sender + " rejected file request\n");
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

            if (msg.type == Type.MESSAGE && !msg.content.equals(".bye")) {
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

}
