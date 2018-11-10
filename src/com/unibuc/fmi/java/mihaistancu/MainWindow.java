package com.unibuc.fmi.java.mihaistancu;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow () {
        // Set window's title
        super("Mihai Stancu's project");

        setLayout(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane();
        add(tabbedPane, BorderLayout.CENTER);

        MazeSolverPanel panelMazeSolver = new MazeSolverPanel();
        MergeSortPanel panelMergeSort = new MergeSortPanel();
        tabbedPane.addTab("Maze Solver", panelMazeSolver);

        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run () {
                new MainWindow();
            }
        });
    }
}
