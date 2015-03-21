package com.tyshchenko.java.training.oop.lesson12.chat.client;

import com.tyshchenko.java.training.oop.lesson12.chat.common.Message;

import javax.swing.*;
import java.io.File;

/**
 * @author Alexander Tyshchenko.
 */
public class ClientChatForm extends JFrame {

    private SocketClient client;
    private int port;
    private String serverAddress;
    private String username;
    private String password;
    private Thread clientThread;
    private File file;
    private String historyFile = "src/main/resources/oop/lesson12/history.xml";
    private HistoryForm historyFrame;
    private History hist;

    private JTextArea clientArea;
    private JTextField textFieldMessage;
    private JTextField textFieldFilePath;
    private JButton buttonSendFile;
    private JButton buttonBrowseFile;
    private JButton buttonSendMessage;
    private JTextField textFieldHostAddress;
    private JTextField textFieldHostPort;
    private JButton buttonConnect;
    private JTextField textFieldUsername;
    private JButton buttonLogin;
    private JButton buttonSignUp;
    private JTextField textFieldHistoryFilePath;
    private JButton buttonBrowseHistory;
    private JButton buttonShowHistory;
    private JList usersList;
    private JPasswordField textFieldPassword;
    private JPanel contentPanel;
    private JLabel lMessage;
    private JLabel lFilePath;
    private JLabel lHostAddress;
    private JLabel lUserName;
    private JLabel lHistoryPath;
    private JLabel lHostPort;
    private JLabel lPassword;
    private JSplitPane centerPanel;
    private JPanel bottomPanel;
    private JPanel topPanel;

    public ClientChatForm(String title) {
        super(title);
        usersList.setSelectedIndex(0);
        buttonConnect.addActionListener(e -> {
            serverAddress = textFieldHostAddress.getText();
            port = Integer.parseInt(textFieldHostPort.getText());

            if (!serverAddress.isEmpty() && !textFieldHostPort.getText().isEmpty()) {
                try {
                    client = new SocketClient(this);
                    clientThread = new Thread(client);
                    clientThread.start();
                    client.send(new Message(Message.Type.PING, "testUser", "testContent", "SERVER"));
                } catch (Exception ex) {
                    clientArea.append("[Application > Me] : Server not found\n");
                }
            }
        });
        buttonLogin.addActionListener(e -> {
            username = textFieldUsername.getText().trim();
//            password = new String(textFieldPassword.getPassword());

            if (!username.isEmpty() /*&& !password.isEmpty()*/) {
                client.send(new Message(Message.Type.LOGIN, username, password, "SERVER"));
            }
        });
        buttonSignUp.addActionListener(e -> {
            username = textFieldUsername.getText();
//            password = new String(textFieldPassword.getPassword());

            if (!username.isEmpty() /*&& !password.isEmpty()*/) {
                client.send(new Message(Message.Type.SIGN_UP, username, password, "SERVER"));
            }
        });
        buttonSendMessage.addActionListener(e -> {
            String msg = textFieldMessage.getText();
            String target = usersList.getSelectedValue().toString();

            if (!msg.isEmpty() && !target.isEmpty()) {
                textFieldMessage.setText("");
                client.send(new Message(Message.Type.MESSAGE, username, msg, target));
            }
        });
        buttonShowHistory.addActionListener(e -> {
            historyFrame.setLocation(this.getLocation());
            historyFrame.setVisible(true);
        });
        buttonBrowseHistory.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.showDialog(this, "Select File");

            if (chooser.getSelectedFile() != null && !chooser.getSelectedFile().getPath().isEmpty()) {
                historyFile = chooser.getSelectedFile().getPath();
//                if(this.isWin32()){
//                    historyFile = historyFile.replace("/", "\\");
//                }
                textFieldHistoryFilePath.setText(historyFile);
                textFieldHistoryFilePath.setEditable(false);
                buttonBrowseHistory.setEnabled(false);
                buttonShowHistory.setEnabled(true);
                hist = new History(historyFile);
            }
        });
        buttonBrowseFile.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showDialog(this, "Select File");
            file = fileChooser.getSelectedFile();

            if (file != null) {
                if (!file.getName().isEmpty()) {
                    buttonSendFile.setEnabled(true);
                    String str;

                    if (textFieldFilePath.getText().length() > 30) {
                        String t = file.getPath();
                        str = t.substring(0, 20) + " [...] " + t.substring(t.length() - 20, t.length());
                    } else {
                        str = file.getPath();
                    }
                    textFieldFilePath.setText(str);
                }
            }
        });
        buttonSendFile.addActionListener(e -> {
            long size = file.length();
            if (size < 120 * 1024 * 1024) {
                client.send(new Message(Message.Type.UPLOAD_REQUEST, username, file.getName(), usersList.getSelectedValue().toString()));
            } else {
                clientArea.append("[Application > Me] : File is size too large\n");
            }
        });

        hist = new History(historyFile);
        historyFrame = new HistoryForm("History", hist);
        historyFrame.setContentPane(historyFrame.getContentPanel());
        historyFrame.getHistoryTable().setModel(historyFrame.getHistoryModel());
        historyFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        historyFrame.pack();
        historyFrame.getHist().fillTable(historyFrame);
        historyFrame.setVisible(false);
    }

    public JButton getButtonBrowseFile() {
        return buttonBrowseFile;
    }

    public JButton getButtonBrowseHistory() {
        return buttonBrowseHistory;
    }

    public JButton getButtonConnect() {
        return buttonConnect;
    }

    public JButton getButtonLogin() {
        return buttonLogin;
    }

    public JButton getButtonSendFile() {
        return buttonSendFile;
    }

    public JButton getButtonSendMessage() {
        return buttonSendMessage;
    }

    public JButton getButtonSignUp() {
        return buttonSignUp;
    }

    public SocketClient getClient() {
        return client;
    }

    public Thread getClientThread() {
        return clientThread;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public File getFile() {
        return file;
    }

    public History getHist() {
        return hist;
    }

    public HistoryForm getHistoryFrame() {
        return historyFrame;
    }

    public JPasswordField getTextFieldPassword() {
        return textFieldPassword;
    }

    public int getPort() {
        return port;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public JTextArea getClientArea() {
        return clientArea;
    }

    public JTextField getTextFieldMessage() {
        return textFieldMessage;
    }

    public JTextField getTextFieldHostAddress() {
        return textFieldHostAddress;
    }

    public JTextField getTextFieldHostPort() {
        return textFieldHostPort;
    }

    public JTextField getTextFieldUsername() {
        return textFieldUsername;
    }

    public String getUsername() {
        return username;
    }

    public DefaultListModel getUserListModel() {
        return (DefaultListModel) usersList.getModel();
    }
}
