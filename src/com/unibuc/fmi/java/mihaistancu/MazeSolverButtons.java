package com.unibuc.fmi.java.mihaistancu;

import javax.swing.*;
import java.awt.*;

public class MazeSolverButtons extends JPanel {

    public MazeSolverButtons() {
        setLayout(new FlowLayout());

        JButton btnSolveMaze = new JButton("Solve Maze");
        add(btnSolveMaze, FlowLayout.LEFT);
    }
}
