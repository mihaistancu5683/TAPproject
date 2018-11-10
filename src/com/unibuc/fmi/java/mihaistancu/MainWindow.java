package com.unibuc.fmi.java.mihaistancu;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
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

    private static JPanel tableMazeSolver() {
        JPanel p = new JPanel();
        Object columnNames[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9  };
        JTable table = new JTable(defaultMaze, columnNames);
        p.add(table);
        p.setPreferredSize(new Dimension(600,400));
        return p;
    }

    private static JPanel btnMazeSolver() {
        JPanel p = new JPanel();
        JButton btnSolveMaze = new JButton("Solve Maze");
        p.add(btnSolveMaze);
        p.setPreferredSize(new Dimension(100,50));
        return p;
    }

    private static JPanel panelMazeSolver() {
        JPanel p = new JPanel();
        p.add(tableMazeSolver());
        p.add(btnMazeSolver());
        return p;
    }

    public MainWindow () {
        // Set window's title
        super("Mihai Stancu's project");

        setLayout(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane();
        add(tabbedPane, BorderLayout.CENTER);
        tabbedPane.addTab("Maze Solver", panelMazeSolver());

        setSize(600,500);
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
