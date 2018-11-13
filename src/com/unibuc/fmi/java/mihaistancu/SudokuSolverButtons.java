package com.unibuc.fmi.java.mihaistancu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuSolverButtons extends JPanel implements ActionListener {
    private int size = 9;
    private JButton btnSolve;
    private JTable table;

    public SudokuSolverButtons(JTable table) {
        this.table = table;
        setLayout(new FlowLayout(FlowLayout.LEFT));

        btnSolve = new JButton("Solve Sudoku");
        btnSolve.addActionListener(this);
        add(btnSolve, FlowLayout.LEFT);
    }

    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        if (clicked == btnSolve) {
            int[][] initialTable = new int[size][size];
            for (int i = 0; i < size; i++){
                for (int j = 0; j < size; j++) {
                    var a = table.getValueAt(i, j);
                    var b = a.toString();
                    var c = Integer.parseInt(b);
                    initialTable[i][j] = Integer.parseInt(table.getValueAt(i, j).toString());
                }
            }

            if(SudokuTable.solve(initialTable, size)) {
                for (int i = 0; i < size; i++){
                    for (int j = 0; j < size; j++) {
                        table.setValueAt(initialTable[i][j], i, j);
                    }
                }
            }
            else {
                System.out.println("There is no solution to the table!");
            }
        }
    }
}