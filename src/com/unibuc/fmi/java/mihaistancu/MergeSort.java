package com.unibuc.fmi.java.mihaistancu;

public class MergeSort {
    static void print(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[])
    {
        int arr[] = {10, 12, 11, 13, 5, 6, 7, 4};
        print(arr);
    }
}
