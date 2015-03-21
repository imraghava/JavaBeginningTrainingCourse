package com.tyshchenko.java.training.oop.lesson12.chat.client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Alexander Tyshchenko.
 */
public class HistoryForm extends JFrame {
    private JPanel contentPanel;
    private JTable historyTable;
    private JScrollPane scrollPane;

    private DefaultTableModel historyModel;

    public History hist;

    public HistoryForm(String title, History hist) {
        super(title);
        this.hist = hist;
        historyModel = new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Sender", "Message", "To", "Time"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };

    }

    public JTable getHistoryTable() {
        return historyTable;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public DefaultTableModel getHistoryModel() {
        return historyModel;
    }

    public History getHist() {
        return hist;
    }
}
