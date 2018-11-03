package com.unibuc.fmi.java.mihaistancu;

import java.util.Random;

public class SudokuTable {
    private int[][] table = new int[9][9];
    private int[][] validTable = new int[][]{
            {5,3,0, 0,7,0, 0,0,0},
            {6,0,0, 1,9,5, 0,0,0},
            {0,9,8, 0,0,0, 0,6,0},

            {8,0,0, 0,6,0, 0,0,3},
            {4,0,0, 8,0,3, 0,0,1},
            {7,0,0, 0,2,0, 0,0,6},

            {0,6,0, 0,0,0, 2,8,0},
            {0,0,0, 4,1,9, 0,0,5},
            {0,0,0, 0,8,0, 0,7,9}
    };
    private int[][] invalidTable = new int[][]{
            {1,0,0, 0,0,0, 0,0,0},
            {0,2,0, 0,0,0, 0,0,0},
            {0,0,3, 0,0,0, 0,0,0},

            {0,0,0, 4,0,0, 0,0,0},
            {0,0,0, 0,5,0, 0,0,0},
            {0,0,0, 0,0,6, 0,0,0},

            {0,0,0, 0,0,0, 7,0,0},
            {0,0,0, 0,0,0, 0,8,0},
            {0,0,0, 0,0,0, 0,0,9},
    };

    private boolean verboseMode = true;

    public static void main(String[] args) {
        SudokuTable table = new SudokuTable();
        table.create();
    }

    // Checks if a given row in the table is valid
    private boolean isRowValid(int rowNumber) {
        NumberOfOccurences no = new NumberOfOccurences();
        for (int value : this.table[rowNumber])
        {
            no.add(value);
        }
        return no.isValid();
    }

    // Generates random integer in a given range
    private int generateRandomIntIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private boolean placeRandomValueAtRandomPosition() {
        int value = generateRandomIntIntRange(1, 9);
        int line = generateRandomIntIntRange(0, 8);
        int column = generateRandomIntIntRange(0, 8);
        if(this.verboseMode){
            System.out.println("Placing the value " + value + " at line " + line + " and column " + column + "\n");
        }
        return true;
    }

    public int[][] create() {
        placeRandomValueAtRandomPosition();
        return this.table;
    }
}
