package com.unibuc.fmi.java.mihaistancu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MazeSolverPanel extends JPanel {
    private MazeSolverButtons msb;
    private JTable table;
    private DefaultTableModel dtm;

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
        dtm = new DefaultTableModel(defaultMaze, columnNames);
        table = new JTable(dtm);
        msb = new MazeSolverButtons(table, dtm);
        add(msb, BorderLayout.NORTH);
        add(table, BorderLayout.CENTER);
    }
}
