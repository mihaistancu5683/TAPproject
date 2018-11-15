package com.unibuc.fmi.java.mihaistancu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MergeSortButtons extends JPanel implements ActionListener {
    private JButton sortMergeSort, delMergeSort, addMergeSort;
    private JTable table;
    private DefaultTableModel dtm;

    public MergeSortButtons(JTable table, DefaultTableModel dtm) {
        this.table=table;
        this.dtm=dtm;
        setLayout(new FlowLayout(FlowLayout.LEFT));

        sortMergeSort = new JButton("Sort");
        sortMergeSort.addActionListener(this);
        add(sortMergeSort, FlowLayout.LEFT);

        delMergeSort = new JButton("Delete");
        add(delMergeSort, FlowLayout.CENTER);

        addMergeSort = new JButton("Add");
        addMergeSort.addActionListener(this);
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
        else if (clicked == addMergeSort) {
            int s = dtm.getRowCount();
            dtm.insertRow(s, new Object[] {0});
            table.setModel(dtm);
        }
    }
}