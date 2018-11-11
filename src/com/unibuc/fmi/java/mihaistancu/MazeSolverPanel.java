package com.unibuc.fmi.java.mihaistancu;

import javax.swing.*;
import java.awt.*;

public class MazeSolverPanel extends JPanel {
    private int mazeRows = 12;
    private int mazeCols = 10;

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
        Object columnNames[] = new Object[mazeCols];
        for(int i = 0; i < mazeCols; i++) {
            columnNames[i] = i;
        }
        MazeSolverButtons msb = new MazeSolverButtons();
        add(msb, BorderLayout.NORTH);
        JTable table = new JTable(defaultMaze, columnNames);
        add(table, BorderLayout.CENTER);
    }
}
