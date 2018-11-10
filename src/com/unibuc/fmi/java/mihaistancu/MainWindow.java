package com.unibuc.fmi.java.mihaistancu;

import javax.swing.*;

public class MainWindow extends JFrame {
    public MainWindow () {
        super("Mihai Stancu's project");
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
