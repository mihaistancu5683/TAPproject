package com.unibuc.fmi.java.mihaistancu;

import javax.swing.*;
import java.awt.*;

public class SudokuSolverPanel extends JPanel {
    SudokuSolverButtons ssb;
    private JTable table;

    private static Object[][] defaultMaze =  new Object[][]{
            {5,3,0, 0,7,0, 0,0,0},
            {6,0,0, 1,9,5, 0,0,0},
            {0,9,8, 0,0,0, 0,6,0},

            {8,0,0, 0,6,0, 0,0,3},
            {4,0,0, 8,0,3, 0,0,1},
            {7,0,0, 0,2,0, 0,0,6},

            {0,6,0, 0,0,0, 2,8,0},
            {0,0,0, 4,1,9, 0,0,5},
            {0,0,0, 0,8,0, 0,7,9}
    };

    public SudokuSolverPanel() {
        setLayout(new BorderLayout());
        Object columnNames[] = new Object[9];
        for(int i = 0; i < 9; i++) {
            columnNames[i] = i;
        }

        table = new JTable(defaultMaze, columnNames);
        ssb = new SudokuSolverButtons(table);
        add(ssb, BorderLayout.NORTH);
        add(table, BorderLayout.CENTER);
    }
}
