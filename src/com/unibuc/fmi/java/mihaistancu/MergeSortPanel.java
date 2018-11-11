package com.unibuc.fmi.java.mihaistancu;

import javax.swing.*;
import java.awt.*;

public class MergeSortPanel extends JPanel {
    private int arrayItems = 10;

    public MergeSortPanel() {

        setLayout(new BorderLayout());
        MergeSortButtons msb = new MergeSortButtons();

        add(msb, BorderLayout.NORTH);

        JTextField txtField = new JTextField("Text");
        add(txtField, BorderLayout.CENTER);
    }
}
