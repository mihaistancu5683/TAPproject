package com.unibuc.fmi.java.mihaistancu;

import javax.swing.*;

public class MergeSortPanel extends JPanel {
    private int arrayItems = 10;

    public MergeSortPanel() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        MergeSortButtons msb = new MergeSortButtons();

        add(msb, BoxLayout.X_AXIS);

        for (int i = 0; i < arrayItems; i++) {
            JTextField txtField = new JTextField(i);
            txtField.setSize(5, 5);
            add(txtField, BoxLayout.Y_AXIS);
            setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        }
    }
}
