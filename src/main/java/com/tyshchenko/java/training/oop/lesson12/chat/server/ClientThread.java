package com.tyshchenko.java.training.oop.lesson12.chat.server;

import com.tyshchenko.java.training.oop.lesson12.chat.common.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author Alexander Tyshchenko.
 */
public class ClientThread extends Thread {

    public SocketServerThread server = null;
    public Socket socket = null;
    public int userId = -1;
    public String username = "";
    public ObjectInputStream socketInputStream = null;
    public ObjectOutputStream socketOutputStream = null;
    public ServerChatForm serverChatForm;

    public ClientThread(SocketServerThread server, Socket socket) {
        this.server = server;
        this.socket = socket;
        userId = this.socket.getPort();
        serverChatForm = server.getServerChatForm();
    }

    public void send(Message message) {
        try {
            socketOutputStream.writeObject(message);
            socketOutputStream.flush();
        } catch (IOException ex) {
            System.out.println("Exception [SocketClient : send(...)]");
        }
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public void run() {
        serverChatForm.getTextArea().append("\nServer Thread " + userId + " running.");
        while (true) {
            try {
                Message msg = (Message) socketInputStream.readObject();
                server.handle(userId, msg);
            } catch (Exception ioe) {
                System.out.println(userId + " ERROR reading: " + ioe.getMessage());
                server.remove(userId);
                break;
            }
        }
    }

    public void open() throws IOException {
        socketOutputStream = new ObjectOutputStream(socket.getOutputStream());
        socketOutputStream.flush();
        socketInputStream = new ObjectInputStream(socket.getInputStream());
    }

    public void close() throws IOException {
        if (socket != null) socket.close();
        if (socketInputStream != null) socketInputStream.close();
        if (socketOutputStream != null) socketOutputStream.close();
    }
}