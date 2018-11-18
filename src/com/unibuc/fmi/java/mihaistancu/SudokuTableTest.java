package com.unibuc.fmi.java.mihaistancu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuTableTest extends SudokuTable{

    @Test
    void getFirstRowTests() {
        assertEquals(0, getFirstRowOfAGivenBoxNumber(0));
        assertEquals(0, getFirstRowOfAGivenBoxNumber(1));
        assertEquals(0, getFirstRowOfAGivenBoxNumber(2));
        assertEquals(3, getFirstRowOfAGivenBoxNumber(3));
        assertEquals(3, getFirstRowOfAGivenBoxNumber(4));
        assertEquals(3, getFirstRowOfAGivenBoxNumber(5));
        assertEquals(6, getFirstRowOfAGivenBoxNumber(6));
        assertEquals(6, getFirstRowOfAGivenBoxNumber(7));
        assertEquals(6, getFirstRowOfAGivenBoxNumber(8));
    }

    @Test
    void getFirstColumnTests() {
        assertEquals(0, getFirstColumnOfAGivenBoxNumber(0));
        assertEquals(3, getFirstColumnOfAGivenBoxNumber(1));
        assertEquals(6, getFirstColumnOfAGivenBoxNumber(2));
        assertEquals(0, getFirstColumnOfAGivenBoxNumber(3));
        assertEquals(3, getFirstColumnOfAGivenBoxNumber(4));
        assertEquals(6, getFirstColumnOfAGivenBoxNumber(5));
        assertEquals(0, getFirstColumnOfAGivenBoxNumber(6));
        assertEquals(3, getFirstColumnOfAGivenBoxNumber(7));
        assertEquals(6, getFirstColumnOfAGivenBoxNumber(8));
    }
}