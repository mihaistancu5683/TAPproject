package com.unibuc.fmi.java.mihaistancu;

public class Maze {
    private char[][] maze;
    private Coordinate start;
    private Coordinate exit;

    // Fill the maze, find start and exit
    public Maze(char[][] mazeArray) {
        this.maze = mazeArray;
        for (int i = 0; i < this.maze.length ; i++) {
            for (int j = 0; j < this.maze[i].length; j++) {
                if (this.maze[i][j] == 'S') {
                    start = new Coordinate(i, j);
                }
                if (this.maze[i][j] == 'E') {
                    exit = new Coordinate(i, j);
                }
            }
        }
    }

    public static void main(String args[]) {
        char[][] mazeArray = new char[][]{
                {'S', ' ', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', '#', '#', '#', ' ', '#', '#', ' ', '#'},
                {'#', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', '#'},
                {'#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', '#'},
                {'#', ' ', '#', '#', ' ', '#', '#', '#', '#', '#'},
                {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#'},
                {'#', '#', '#', '#', '#', ' ', '#', '#', '#', '#'},
                {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', 'E'},
                {'#', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
        };
        Maze maze = new Maze(mazeArray);
    }
}