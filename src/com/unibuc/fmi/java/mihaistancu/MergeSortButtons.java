package com.unibuc.fmi.java.mihaistancu;

import javax.swing.*;
import java.awt.*;

public class MergeSortButtons extends JPanel {
    private int arrayItems = 5;

    public MergeSortButtons() {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton sortMergeSort = new JButton("Sort");
        add(sortMergeSort, FlowLayout.LEFT);

        JButton delMergeSort = new JButton("Delete");
        add(delMergeSort, FlowLayout.CENTER);

        JButton addMergeSort = new JButton("Add");
        add(addMergeSort, FlowLayout.RIGHT);
    }
}