package com.unibuc.fmi.java.mihaistancu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MergeSortButtons extends JPanel implements ActionListener {
    private JButton sortMergeSort, delMergeSort, addMergeSort;
    private JTable table;

    public MergeSortButtons(JTable table) {
        this.table=table;
        setLayout(new FlowLayout(FlowLayout.LEFT));

        sortMergeSort = new JButton("Sort");
        sortMergeSort.addActionListener(this);
        add(sortMergeSort, FlowLayout.LEFT);

        delMergeSort = new JButton("Delete");
        add(delMergeSort, FlowLayout.CENTER);

        addMergeSort = new JButton("Add");
        add(addMergeSort, FlowLayout.RIGHT);
    }

    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        if (clicked == sortMergeSort) {
            int rows = table.getRowCount();
            int[] arr = new int[rows];
            for (int i = 0; i < rows; i++){
                arr[i] = Integer.parseInt(table.getValueAt(i, 0).toString());
            }

            MergeSort ms = new MergeSort(arr);
            ms.sort(0, arr.length - 1);

            for (int i = 0; i < rows; i++){
                table.setValueAt(arr[i], i, 0);
            }
        }
    }
}