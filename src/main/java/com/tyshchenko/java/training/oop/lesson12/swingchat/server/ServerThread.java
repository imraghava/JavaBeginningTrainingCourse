package com.tyshchenko.java.training.oop.lesson12.swingchat.server;

import com.tyshchenko.java.training.oop.lesson12.swingchat.common.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author Alexander Tyshchenko.
 */
public class ServerThread extends Thread {

    public ChatSocketServer server = null;
    public Socket socket = null;
    public int ID = -1;
    public String username = "";
    public ObjectInputStream socketInputStream = null;
    public ObjectOutputStream socketOutputStream = null;
    public ServerChatForm serverChatForm;

    public ServerThread(ChatSocketServer server, Socket socket) {
        this.server = server;
        this.socket = socket;
        ID = this.socket.getPort();
        serverChatForm = server.getServerChatForm();
    }

    public void send(Message msg) {
        try {
            socketOutputStream.writeObject(msg);
            socketOutputStream.flush();
        } catch (IOException ex) {
            System.out.println("Exception [SocketClient : send(...)]");
        }
    }

    public int getID() {
        return ID;
    }

    @Override
    public void run() {
        serverChatForm.getTextArea().append("\nServer Thread " + ID + " running.");
        while (true) {
            try {
                Message msg = (Message) socketInputStream.readObject();
                server.handle(ID, msg);
            } catch (Exception ioe) {
                System.out.println(ID + " ERROR reading: " + ioe.getMessage());
                server.remove(ID);
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