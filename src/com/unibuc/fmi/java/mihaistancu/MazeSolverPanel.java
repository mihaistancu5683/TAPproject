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
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Object columnNames[] = new Object[mazeCols];
        for(int i = 0; i < mazeCols; i++) {
            columnNames[i] = i;
        }
        JButton btnSolveMaze = new JButton("Solve Maze");
        add(btnSolveMaze, BoxLayout.X_AXIS);
        JTable table = new JTable(defaultMaze, columnNames);
        add(table, BoxLayout.Y_AXIS);
    }
}
