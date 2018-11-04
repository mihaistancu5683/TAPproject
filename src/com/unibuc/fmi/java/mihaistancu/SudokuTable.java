package com.unibuc.fmi.java.mihaistancu;

public class SudokuTable {
    public static void main(String[] args) {
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

        int n = uniqueTable.length;

        if(solve(uniqueTable, n)) {
            print(uniqueTable);
        }
        else {
            System.out.println("There is no solution to the table!");
        }
    }

    public static boolean solve(int[][] table, int n){
        int nextEmptyRow = -1;
        int nextEmptyCol = -1;
        boolean isSolved = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(table[i][j] == 0) {
                    // Found empty cell
                    nextEmptyRow = i;
                    nextEmptyCol = j;
                    isSolved = false;
                    break;
                }
            }
            if(!isSolved) {
                break;
            }
        }

        // No more empty spaces
        if(isSolved) {
            System.out.println("Done! Solution:");
            return true;
        }

        // Try to place numbers in order on the empty spot
        for( int val = 1; val <= n ; val++)
        {
            if (canWePlace(table, nextEmptyRow, nextEmptyCol, val))
            {
                table[nextEmptyRow][nextEmptyCol] = val;
                if (solve(table, n)) {// backtrack
                    return true;
                }
                else {
                    // delete it
                    table[nextEmptyRow][nextEmptyCol] = 0;
                }
            }
        }
        return false;
    }

    // Checks a given row for a certain value
    public static boolean doesRowHaveValue(int[][] table, int rowNumber, int value) {
        for (int i = 0; i < 9; i++)
        {
            if(table[rowNumber][i] == value) {
                return true;
            }
        }
        return false;
    }

    // Checks a given column for a certain value
    public static boolean doesColumnHaveValue(int[][] table, int colNumber, int value) {
        for (int i = 0; i < 9; i++)
        {
            if(table[i][colNumber] == value) {
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
    public static int getFirstRowOfAGivenBoxNumber(int boxNumber) {
        return (boxNumber / 3) * 3;
    }

    public static int getFirstColumnOfAGivenBoxNumber(int boxNumber) {
        return (boxNumber % 3) * 3;
    }

    // boxNumber     i        j
    //     0         0        0
    //     0         0        1
    //     0         0        2
    //     0         1        0
    //     0         1        1
    //     0         1        2
    //     0         2        0
    //     0         2        1
    //     0         2        2
    public static int getBoxNumberOfAGivenElement(int i, int j) {
        int m, n;
        if (i < 3) {
            m = 0; // upper box
        }
        else if (i < 6) {
            m = 1; // middle box
        }
        else {
            m = 2; // lower box
        }
        if (j < 3) {
            n = 0; // left box
        }
        else if (j < 6) {
            n = 1; // middle box
        }
        else {
            n = 2; // right box
        }
        return 3*m + n;
    }

    // Checks a given box for a certain value
    public static boolean doesBoxHaveValue(int[][] table, int boxNumber, int value) {
        int firsti = getFirstRowOfAGivenBoxNumber(boxNumber);
        int firstj = getFirstColumnOfAGivenBoxNumber(boxNumber);
        int lasti = firsti + 3;
        int lastj  = firstj + 3;
        for (int i = firsti; i < lasti; i++)
        {
            for (int j = firstj; j < lastj; j++)
            {
                if(table[i][j] == value) {
                    return true;
                }
            }
        }
        return false;
    }

    // Checks if an entire table is valid
    public static boolean canWePlace(int[][] table, int row, int col, int value)
    {
        int box = getBoxNumberOfAGivenElement(row, col);
        return ((!doesRowHaveValue(table, row, value)) && (!doesColumnHaveValue(table, col, value)) && (!doesBoxHaveValue(table, box, value)));
    }

    public static void print(int[][] table) {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                System.out.print(table[i][j] + " ");
            }
            System.out.println(table[i][8]);
        }
    }
}
