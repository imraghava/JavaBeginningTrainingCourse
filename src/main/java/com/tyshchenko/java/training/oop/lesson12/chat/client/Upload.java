package com.tyshchenko.java.training.oop.lesson12.chat.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Alexander Tyshchenko.
 */
public class Upload implements Runnable {

    private String address;
    private int port;
    private File file;
    private ClientChatForm clientChatForm;

    public Upload(String address, int port, File file, ClientChatForm clientChatForm) {
        this.file = file;
        this.port = port;
        this.clientChatForm = clientChatForm;
        this.address = address;
    }

    @Override
    public void run() {
        try (Socket socket = new Socket(InetAddress.getByName(address), port);
             OutputStream outputStream = socket.getOutputStream();
             FileInputStream inputStream = new FileInputStream(file)
        ) {
            byte[] buffer = new byte[1024];
            int count;

            while ((count = inputStream.read(buffer)) >= 0) {
                outputStream.write(buffer, 0, count);
            }
            outputStream.flush();

            clientChatForm.getClientArea().append("[Application > Me] : File upload complete\n");
//            serverChatForm.button3.setEnabled(true);
            clientChatForm.getButtonSendFile().setEnabled(true);
//            serverChatForm.textField2.setVisible(true);
        } catch (Exception ex) {
            System.out.println("Exception [Upload : run()]");
            ex.printStackTrace();
        }
    }

}
