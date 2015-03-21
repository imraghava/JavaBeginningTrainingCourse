package com.tyshchenko.java.training.oop.lesson12.swingchat.server;

import javax.swing.*;
import java.io.File;

/**
 * @author Alexander Tyshchenko.
 */
public class ServerChatForm extends JFrame {

    private ChatSocketServer server;
    private String filePath = "src/main/resources/oop/lesson11/database.xml";
    private JFileChooser fileChooser = new JFileChooser();

    private JPanel contentPanel;
    private JTextArea textArea;
    private JButton buttonStartServer;
    private JButton buttonBrowseDatabaseFile;
    private JTextField textFieldDatabasePath;
    private JScrollPane scrollPane;
    private JPanel pBottom;
    private JLabel lDatabase;

    public ServerChatForm(String title) {
        super(title);
        buttonBrowseDatabaseFile.addActionListener(
            e -> {
                fileChooser.showDialog(this, "Select");
                File file = fileChooser.getSelectedFile();

                if (file != null) {
                    filePath = file.getPath();
                    if (this.isWin32()) {
                        filePath = filePath.replace("\\", "/");
                    }
                    textFieldDatabasePath.setText(filePath);
                    buttonStartServer.setEnabled(true);
                }
            });
        buttonStartServer.addActionListener(
            e -> {
                server = new ChatSocketServer(this);
                buttonStartServer.setEnabled(false);
                buttonBrowseDatabaseFile.setEnabled(false);
            });
    }


    public boolean isWin32() {
        return System.getProperty("os.name").startsWith("Windows");
    }

    public void retryStart(int port) {
        if (server != null) {
            server.stop();
        }
        server = new ChatSocketServer(this, port);
    }

    public String getFilePath() {
        return filePath;
    }

    public ChatSocketServer getServer() {
        return server;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }
}
