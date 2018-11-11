package com.unibuc.fmi.java.mihaistancu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MazeSolverButtons extends JPanel implements ActionListener  {
    private JButton btnSolveMaze;
    private JTable table;

    public MazeSolverButtons(JTable table) {
        this.table = table;
        setLayout(new FlowLayout(FlowLayout.LEFT));

        btnSolveMaze = new JButton("Solve Maze");
        btnSolveMaze.addActionListener(this);
        add(btnSolveMaze, FlowLayout.LEFT);
    }

    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        if (clicked == btnSolveMaze) {
            int rows = table.getRowCount();
            int cols = table.getColumnCount();
            char[][] mazeArray = new char[rows][cols];
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < cols; j++) {
                    mazeArray[i][j] = (char) table.getValueAt(i, j);
                }
            }

            Maze maze = new Maze(mazeArray);
            List<Coordinate> path = maze.solve();
            char[][] solution = maze.getSolvedMaze(path);

            for (int i = 0; i < rows; i++){
                for (int j = 0; j < cols; j++) {
                    table.setValueAt(solution[i][j], i, j);
                }
            }
        }
    }
}
