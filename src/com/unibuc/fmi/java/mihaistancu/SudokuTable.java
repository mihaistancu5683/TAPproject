package com.unibuc.fmi.java.mihaistancu;

import java.util.Random;

public class SudokuTable {
    private int[][] table;

    public void SudokuTable() {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                this.table[i][j] = 0;
            }
        }
    }

    public void SudokuTable(int[][] newTable) {
        this.table = newTable;
    }

    public static void main(String[] args) {
        int[][] solvedTable = new int[][]{
                {6,3,8, 5,2,4, 9,7,1},
                {4,9,7, 8,3,1, 6,2,5},
                {1,5,2, 6,9,7, 8,3,4},

                {8,6,9, 7,5,2, 1,4,3},
                {7,2,3, 1,4,6, 5,9,8},
                {5,4,1, 9,8,3, 2,6,7},

                {3,1,4, 2,6,5, 7,8,9},
                {9,7,6, 4,1,8, 3,5,2},
                {2,8,5, 3,7,9, 4,1,6}
        };
        int[][] notUniqueTable = new int[][]{
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
         int[][] uniqueTable = new int[][]{
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
         SudokuTable st = new SudokuTable();
         st.table = uniqueTable;
         st.print();
    }

    // Checks a given row for a certain value
    private boolean doesRowHaveValue(int rowNumber, int value) {
        for (int i = 0; i < 9; i++)
        {
            if(this.table[rowNumber][i] == value) {
                return true;
            }
        }
        return false;
    }

    // Checks a given column for a certain value
    private boolean doesColumnHaveValue(int colNumber, int value) {
        for (int i = 0; i < 9; i++)
        {
            if(this.table[i][colNumber] == value) {
                return true;
            }
        }
        return false;
    }

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
    private int getFirstRowOfAGivenBoxNumber(int boxNumber) {
        return (boxNumber / 3) * 3;
    }

    private int getFirstColumnOfAGivenBoxNumber(int boxNumber) {
        return (boxNumber % 3) * 3;
    }

    private int getBoxNumberOfAGivenElement(int i, int j) {
        return (j/3)+i;
    }

    // Checks a given box for a certain value
    private boolean doesBoxHaveValue(int boxNumber, int value) {
        int firsti = getFirstRowOfAGivenBoxNumber(boxNumber);
        int firstj = getFirstColumnOfAGivenBoxNumber(boxNumber);
        int lasti = firsti + 3;
        int lastj  = firstj + 3;
        for (int i = firsti; i < lasti; i++)
        {
            for (int j = firstj; j < lastj; j++)
            {
                if(this.table[i][j] == value) {
                    return true;
                }
            }
        }
        return false;
    }

    // Checks if an entire table is valid
    private boolean canWePlace(int row, int col, int value)
    {
        int box = getBoxNumberOfAGivenElement(row, col);
        return ((!doesRowHaveValue(row, value)) && (!doesColumnHaveValue(col, value)) && (!doesBoxHaveValue(box, value)));
    }

    public void print() {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                System.out.print(this.table[i][j] + " ");
            }
            System.out.println(this.table[i][8]);
        }
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
        return true;
    }

    public int[][] create() {
        placeRandomValueAtRandomPosition();
        return this.table;
    }
}
