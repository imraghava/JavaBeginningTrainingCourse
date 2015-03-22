package com.tyshchenko.java.training.oop.lesson12.chat.client;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Alexander Tyshchenko.
 */
public class Downloader implements Runnable {

    private ServerSocket server;
    private Socket socket;
    private int port;
    private String saveTo = "";
    private InputStream inputStream;
    private FileOutputStream fileOutputStream;
    private ClientChatForm clientChatForm;

    public Downloader(String saveTo, ClientChatForm clientChatForm) {
        try {
            server = new ServerSocket(0);
            port = server.getLocalPort();
            this.saveTo = saveTo;
            this.clientChatForm = clientChatForm;
        } catch (IOException ex) {
            System.out.println("Exception [Download : Download(...)]");
        }
    }

    @Override
    public void run() {
        try {
            socket = server.accept();
            System.out.println("Download : " + socket.getRemoteSocketAddress());

            inputStream = socket.getInputStream();
            fileOutputStream = new FileOutputStream(saveTo);

            byte[] buffer = new byte[1024];
            int count;

            while ((count = inputStream.read(buffer)) >= 0) {
                fileOutputStream.write(buffer, 0, count);
            }

            fileOutputStream.flush();

            clientChatForm.getClientArea().append("[Application > Me] : Download complete\n");

            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (Exception ex) {
            System.out.println("Exception [Download : run(...)]");
        }
    }

    public int getPort() {
        return port;
    }
}
