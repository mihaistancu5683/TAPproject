package com.unibuc.fmi.java.mihaistancu;

import java.util.*;

public class Maze {
    private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    private char[][] maze;
    private boolean[][] visited;
    private Coordinate start;
    private Coordinate exit;

    public int getHeight() {
        return maze.length;
    }

    public int getWidth() {
        return maze[0].length;
    }

    public Coordinate getEntry() {
        return start;
    }

    public boolean isExit(int x, int y) {
        return x == exit.getX() && y == exit.getY();
    }

    public boolean isStart(int x, int y) {
        return x == start.getX() && y == start.getY();
    }

    public boolean isExplored(int row, int col) {
        return visited[row][col];
    }

    public boolean isWall(int row, int col) {
        return maze[row][col] == '#';
    }

    public void setVisited(int row, int col, boolean value) {
        visited[row][col] = value;
    }

    public boolean isValidLocation(int row, int col) {
        if (row < 0 || row >= getHeight() || col < 0 || col >= getWidth()) {
            return false;
        }
        return true;
    }

    // Fill the maze, find start and exit
    public Maze(char[][] mazeArray) {
        this.maze = mazeArray;
        visited = new boolean[maze.length][maze[0].length];
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

    // Iterates through the linked list and returns the path
    private List<Coordinate> backtrackPath(Coordinate cur) {
        List<Coordinate> path = new ArrayList<>();
        Coordinate iter = cur;

        while (iter != null) {
            path.add(iter);
            iter = iter.parent;
        }

        return path;
    }

    // BFS Algorithm
    public List<Coordinate> solve() {
        LinkedList<Coordinate> nextToVisit = new LinkedList<>();
        // Get entry point, mark it as visited
        Coordinate start = this.getEntry();
        nextToVisit.add(start);

        // While we still have items to visit
        while (!nextToVisit.isEmpty()) {
            // Returns the first element in the list
            Coordinate cur = nextToVisit.remove();

            // If the coord is invalid or explored, go to next one
            if (!this.isValidLocation(cur.getX(), cur.getY()) || this.isExplored(cur.getX(), cur.getY())) {
                continue;
            }

            // If the coord is wall, set as visited and go to next
            if (this.isWall(cur.getX(), cur.getY())) {
                this.setVisited(cur.getX(), cur.getY(), true);
                continue;
            }

            // If the coord is exit, return path, we're done!
            if (this.isExit(cur.getX(), cur.getY())) {
                return backtrackPath(cur);
            }

            // Mark as visited all of the neighbors
            for (int[] direction : DIRECTIONS) {
                Coordinate coordinate = new Coordinate(cur.getX() + direction[0], cur.getY() + direction[1], cur);
                nextToVisit.add(coordinate);
                this.setVisited(cur.getX(), cur.getY(), true);
            }
        }
        // Solution not found
        return Collections.emptyList();
    }

    public char[][] getSolvedMaze(List<Coordinate> path) {
        // Copy the array to a temporary one
        int h = this.getHeight();
        int w = this.getWidth();
        char[][] tempMaze = new char[h][w];
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                tempMaze[row][col] = maze[row][col];
            }
        }

        // Add path to temporary array
        for (Coordinate coordinate : path) {
            if (isStart(coordinate.getX(), coordinate.getY()) || isExit(coordinate.getX(), coordinate.getY())) {
                continue;
            }
            tempMaze[coordinate.getX()][coordinate.getY()] = '.';
        }

        return tempMaze;
    }
}