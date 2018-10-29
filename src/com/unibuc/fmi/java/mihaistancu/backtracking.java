package com.unibuc.fmi.java.mihaistancu;

import java.util.Random;

public class backtracking {
    public static void main(String[] args) {
        int x = generateRandomIntIntRange(1,9);
        System.out.println(x);
    }


    public static int generateRandomIntIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
