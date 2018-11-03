package com.unibuc.fmi.java.mihaistancu;

public class NumberOfOccurences {
    private int[] actualData = new int[10];
    private int[] expectedData = new int[10];

    // Constructor: add initial actual data and expected data
    public NumberOfOccurences() {
        this.actualData = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        this.expectedData = new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    }

    // Checks the validity (actual data compared to expected data)
    public boolean isValid() {
        boolean result = true;
        for (int i = 0; i < 10; i++)
        {
            if( actualData[i] != expectedData[i]){
                result = false;
            }
        }
        return result;
    }

    // Adds a number to the actual data
    public void add(int number) {
        this.actualData[number]++;
    }

    // Prints actual data
    public void print() {
        for (int i = 0; i < 10; i++)
        {
            System.out.print(actualData[i] + " ");
        }
        System.out.println();
    }

    // Just for testing purposes
    public static void main(String[] args) {
        NumberOfOccurences no = new NumberOfOccurences();
        for (int i = 1; i < 10; i++)
        {
            no.add(i);
        }
        boolean res = no.isValid();
        no.print();
        System.out.println(res);
        no.add(0);
        boolean res2 = no.isValid();
        no.print();
        System.out.println(res2);
    }
}
