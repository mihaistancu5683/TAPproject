package com.unibuc.fmi.java.mihaistancu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MergeSortPanel extends JPanel {
    private JTable table;
    private DefaultTableModel dtm;
    Object[][] defaultArray = {{10}, {12}, {11}, {13}, {5}, {6}, {7}, {4}};

    public MergeSortPanel() {
        Object[][] columnNames = new Object[][] {{0}};
        dtm = new DefaultTableModel(defaultArray, columnNames);

        setLayout(new BorderLayout());

        table = new JTable(dtm);
        MergeSortButtons msb = new MergeSortButtons(table, dtm);

        add(msb, BorderLayout.NORTH);
        add(table, BorderLayout.CENTER);
    }
}
