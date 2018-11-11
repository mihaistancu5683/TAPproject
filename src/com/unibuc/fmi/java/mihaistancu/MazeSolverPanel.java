package com.unibuc.fmi.java.mihaistancu;

import javax.swing.*;
import java.awt.*;

public class MazeSolverPanel extends JPanel {
    private MazeSolverButtons msb;
    private JTable table;

    private static Object[][] defaultMaze =  new Object[][]{
            {'S', ' ', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', '#', '#', ' ', '#', '#', ' ', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', '#'},
            {'#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', '#'},
            {'#', ' ', '#', '#', ' ', '#', '#', '#', '#', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#'},
            {'#', '#', '#', '#', '#', ' ', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', 'E'},
            {'#', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
    };

    public MazeSolverPanel() {
        setLayout(new BorderLayout());
        int cols = defaultMaze[0].length;
        Object columnNames[] = new Object[cols];
        for(int i = 0; i < cols; i++) {
            columnNames[i] = i;
        }
        table = new JTable(defaultMaze, columnNames);
        msb = new MazeSolverButtons(table);
        add(msb, BorderLayout.NORTH);
        add(table, BorderLayout.CENTER);
    }
}
