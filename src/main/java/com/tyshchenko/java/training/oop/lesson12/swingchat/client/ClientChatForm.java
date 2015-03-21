package com.tyshchenko.java.training.oop.lesson12.swingchat.client;

import com.tyshchenko.java.training.oop.lesson12.swingchat.common.Message;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private String historyFile = "src/main/resources/oop/lesson11/history.xml";
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
            password = new String(textFieldPassword.getPassword());

            if (!username.isEmpty() && !password.isEmpty()) {
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
            JFileChooser jf = new JFileChooser();
            jf.showDialog(this, "Select File");

            if(!jf.getSelectedFile().getPath().isEmpty()){
                historyFile = jf.getSelectedFile().getPath();
//                if(this.isWin32()){
//                    historyFile = historyFile.replace("/", "\\");
//                }
                textFieldHistoryFilePath.setText(historyFile);
                textFieldHistoryFilePath.setEditable(false);
                buttonBrowseHistory.setEnabled(false);
                buttonShowHistory.setEnabled(true);
                hist = new History(historyFile);

                historyFrame = new HistoryForm("History", hist);
                historyFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                historyFrame.setVisible(false);
            }
        });
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

    public JPanel getBottomPanel() {
        return bottomPanel;
    }

    public JButton getButtonSendFile() {
        return buttonSendFile;
    }

    public JButton getButtonSendMessage() {
        return buttonSendMessage;
    }

    public JButton getButtonShowHistory() {
        return buttonShowHistory;
    }

    public JButton getButtonSignUp() {
        return buttonSignUp;
    }

    public JSplitPane getCenterPanel() {
        return centerPanel;
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

    public String getHistoryFile() {
        return historyFile;
    }

    public HistoryForm getHistoryFrame() {
        return historyFrame;
    }

    public JLabel getlFilePath() {
        return lFilePath;
    }

    public JLabel getlHistoryPath() {
        return lHistoryPath;
    }

    public JLabel getlHostAddress() {
        return lHostAddress;
    }

    public JLabel getlHostPort() {
        return lHostPort;
    }

    public JLabel getlMessage() {
        return lMessage;
    }

    public JLabel getlPassword() {
        return lPassword;
    }

    public JLabel getlUserName() {
        return lUserName;
    }

    public String getPassword() {
        return password;
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

    public JTextField getTextFieldFilePath() {
        return textFieldFilePath;
    }

    public JTextField getTextFieldHistoryFilePath() {
        return textFieldHistoryFilePath;
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

    public JPanel getTopPanel() {
        return topPanel;
    }

    public String getUsername() {
        return username;
    }

    public JList getUsersList() {
        return usersList;
    }

    public DefaultListModel getUserListModel() {
        return (DefaultListModel)usersList.getModel();
    }
}
