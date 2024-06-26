package shree.exp.BackTracking;


import shree.exp.Utils;

public class RatInAMaze {

    /*
     * https://www.geeksforgeeks.org/rat-in-a-maze/
     */
    public static void main(String args[]) {
        RatInAMaze rat = new RatInAMaze();
        int maze[][] = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        rat.solveMaze(maze);
    }

    public void solveMaze(int[][] maze) {

        int[][] solution = new int[maze.length][maze[0].length];

        if (solveRecursive(maze, 0, 0, solution)) {
            Utils.printMatrix(solution);
        } else {
            System.out.println("No Solution");
        }
    }

    private boolean solveRecursive(int[][] maze, int i, int j, int[][] solution) {

        if (i == maze.length - 1 && j == maze[0].length - 1) {
            solution[i][j] = 1;
            return true;
        }

        if (isSafe(maze, i, j)) {

            solution[i][j] = 1;
            if (solveRecursive(maze, i + 1, j, solution)) {
                return true;
            }

            if (solveRecursive(maze, i, j + 1, solution)) {
                return true;
            }

            solution[i][j] = 0;
        }

        return false;
    }

    private boolean isSafe(int[][] maze, int i, int j) {
        return ((i >= 0) && (i < maze.length) && (j >= 0) && (j < maze[0].length)
                && (maze[i][j] == 1));
    }


}
