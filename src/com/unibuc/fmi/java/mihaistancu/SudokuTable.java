package com.unibuc.fmi.java.mihaistancu;

import java.util.Random;

public class SudokuTable {
    private int[][] table = new int[9][9];
    private int[][] uniqueTable = new int[][]{
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
    private int[][] notUniqueTable = new int[][]{
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
        for (int i = 0; i < 9; i++)
        {
            no.add(this.table[rowNumber][i]);
        }
        return no.isValid();
    }

    // Checks if a given column in the table is valid
    private boolean isColumnValid(int colNumber) {
        NumberOfOccurences no = new NumberOfOccurences();
        for (int i = 0; i < 9; i++)
        {
            no.add(this.table[i][colNumber]);
        }
        return no.isValid();
    }

    // Checks if a given box in the table is valid
    private boolean isBoxValid(int boxNumber) {
        // boxNumber  first i  first j
        //     0         0        0
        //     1         0        3
        //     2         0        6
        //     3         3        0
        //     4         3        3
        //     5         3        6
        //     6         6        0
        //     7         6        3
        //     8         6        6
        int firsti = (boxNumber / 3) * 3;
        int firstj = (boxNumber % 3) * 3;
        int lasti = firsti + 3;
        int lastj  = firstj + 3;
        //System.out.println("first i=" + firsti);
        //System.out.println("first j=" + firstj);
        NumberOfOccurences no = new NumberOfOccurences();
        for (int i = firsti; i < lasti; i++)
        {
            for (int j = firstj; j < lastj; j++)
            {
                //System.out.println("i=" + i + " j=" + j + " val="  +this.solvedTable[i][j]);
                no.add(this.table[i][j]);
            }
        }
        return no.isValid();
    }

    // Checks if an entire table is valid
    private boolean isTableValid()
    {
        boolean result = true;
        for (int i = 0; i < 9; i++)
        {
            if((!isRowValid(i)) || (!isColumnValid(i)) || (!isBoxValid(i)))
            {
                result = false;
            }
        }
        return result;
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
