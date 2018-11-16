package com.unibuc.fmi.java.mihaistancu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MazeSolverButtons extends JPanel implements ActionListener  {
    private JButton btnSolveMaze, btnAddRow, btnDelRow;
    private JTable table;
    private DefaultTableModel dtm;

    public MazeSolverButtons(JTable table, DefaultTableModel dtm) {
        this.table = table;
        this.dtm = dtm;
        setLayout(new FlowLayout(FlowLayout.LEFT));

        btnSolveMaze = new JButton("Solve Maze");
        btnSolveMaze.addActionListener(this);

        btnAddRow = new JButton("Add row");
        btnAddRow.addActionListener(this);

        btnDelRow = new JButton("Delete row");
        btnDelRow.addActionListener(this);

        add(btnSolveMaze, FlowLayout.LEFT);
        add(btnAddRow, FlowLayout.LEFT);
        add(btnDelRow, FlowLayout.LEFT);
    }

    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        int rows = dtm.getRowCount();
        int cols = dtm.getColumnCount();
        if (clicked == btnSolveMaze) {
            char[][] mazeArray = new char[rows][cols];
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < cols; j++) {
                    mazeArray[i][j] = dtm.getValueAt(i, j).toString().charAt(0);
                }
            }

            Maze maze = new Maze(mazeArray);
            List<Coordinate> path = maze.solve();
            char[][] solution = maze.getSolvedMaze(path);

            for (int i = 0; i < rows; i++){
                for (int j = 0; j < cols; j++) {
                    dtm.setValueAt(solution[i][j], i, j);
                }
            }
        }
        else if (clicked == btnAddRow) {
            Object[] newRowData = new Object[cols];
            for (int j = 0; j < cols; j++){
                newRowData[j]=" ";
            }
            dtm.insertRow(rows, newRowData);
        }

        else if (clicked == btnDelRow) {
            dtm.removeRow(rows - 1);
        }
        table.setModel(dtm);
    }
}
