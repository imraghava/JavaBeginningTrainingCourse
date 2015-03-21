package com.tyshchenko.java.training.oop.lesson12.swingchat.client;

import javax.swing.*;
import java.awt.*;

/**
 * @author Alexander Tyshchenko.
 */
public class Client {

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

    public void start() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Nimbus LookAndFeel is unavailable");
        }

        EventQueue.invokeLater(() -> {
            ClientChatForm frame = new ClientChatForm("ClientChatForm");
            frame.setContentPane(frame.getContentPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }

}
