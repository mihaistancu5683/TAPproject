package com.unibuc.fmi.java.mihaistancu;

import javax.swing.*;
import java.awt.*;

public class MergeSortPanel extends JPanel {
    private JTable table;
    Object[][] defaultArray = {{10}, {12}, {11}, {13}, {5}, {6}, {7}, {4}};

    public MergeSortPanel() {

        setLayout(new BorderLayout());

        Object[][] columnNames = new Object[][] {{0}};
        table = new JTable(defaultArray, columnNames);
        MergeSortButtons msb = new MergeSortButtons(table);

        add(msb, BorderLayout.NORTH);
        add(table, BorderLayout.CENTER);
    }
}
