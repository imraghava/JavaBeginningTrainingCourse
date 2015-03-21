package com.tyshchenko.java.training.oop.lesson12.swingchat.client;

import javax.swing.*;
import java.awt.*;

/**
 * @author Alexander Tyshchenko.
 */
public class HistoryForm extends JFrame {
    private JPanel contentPanel;
    private JTable historyTable;
    private JScrollPane scrollPane;

    public History hist;

    public HistoryForm(String title, History hist) {
        super(title);
        this.hist = hist;
    }

    public JTable getHistoryTable() {
        return historyTable;
    }

}
