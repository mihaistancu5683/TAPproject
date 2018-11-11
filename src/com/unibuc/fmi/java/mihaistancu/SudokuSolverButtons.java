package com.unibuc.fmi.java.mihaistancu;

import javax.swing.*;
import java.awt.*;

public class SudokuSolverButtons extends JPanel {
    private int arrayItems = 5;

    public SudokuSolverButtons() {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton btnSolveSudoku = new JButton("Solve Sudoku");
        add(btnSolveSudoku, FlowLayout.LEFT);
    }
}