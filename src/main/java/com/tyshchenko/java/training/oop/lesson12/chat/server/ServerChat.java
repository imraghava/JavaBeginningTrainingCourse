package com.tyshchenko.java.training.oop.lesson12.chat.server;

import com.tyshchenko.java.training.oop.lesson12.chat.client.Message;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Alexander Tyshchenko.
 */
public class ServerChat {

    private int port;
    private Thread thread;
    private List<Message> msg = Collections.synchronizedList(new ArrayList<>());

    public ServerChat(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        ServerChat s = new ServerChat(5000);
        s.start();
    }

    public void start() throws IOException {
        thread = new Thread() {
            @Override
            public void run() {
                try {
                    ServerSocket s = new ServerSocket(port);

                    while ( ! isInterrupted()) {
                        Socket c = s.accept();

                        ClientThread ct = new ClientThread(c, msg);
                        ct.start();
                    }

                    s.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }
}
