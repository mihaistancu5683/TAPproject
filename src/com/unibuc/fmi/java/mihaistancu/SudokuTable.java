package com.unibuc.fmi.java.mihaistancu;

import java.util.Random;

public class SudokuTable {
    private int[][] table = new int[9][9];
    private boolean verboseMode = true;

    public static void main(String[] args) {
        SudokuTable table = new SudokuTable();
        table.create();
    }

    private int generateRandomIntIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private boolean placeRandomValueAtRandomPosition() {
        int value = generateRandomIntIntRange(1, 9);
        int position = generateRandomIntIntRange(0, 8);
        if(this.verboseMode){
            System.out.println("Placing the value " + value + " at position " + position + "\n");
        }
        return true;
    }

    public int[][] create() {
        placeRandomValueAtRandomPosition();
        return this.table;
    }
}
