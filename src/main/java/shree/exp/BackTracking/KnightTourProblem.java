package shree.exp.BackTracking;

import shree.exp.Utils;

/**
 * -- YET TO BE COMPLETED !!!
 */
public class KnightTourProblem {

    private final int N = 8;

    private final int[] xCoordinates = {-1, -2, 1, 2, -2, -1, 1, 2};
    private final int[] yCoordinates = {2, 1, 2, 1, -1, -2, -2, -1};


    public static void main(String[] args) {
        KnightTourProblem k = new KnightTourProblem();

        k.tour();
    }

    private void tour() {
        int[][] board = new int[N][N];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = -1;
            }
        }

        board[0][0] = 0;

        if(recurse(board, 0, 0, 1)) {
            Utils.printMatrix(board);
        } else {
            Utils.printMatrix(board);
            System.out.println("No Solution");
        }

    }

    private boolean recurse(int[][] matrix, int i, int j, int steps) {

        if (steps == N * N) {
            return true;
        }

        for (int k = 0; k < N; k++) {
            int iNext = i + xCoordinates[k];
            int jNext = j + yCoordinates[k];

            if (isSafe(matrix, iNext, jNext)) {
                matrix[iNext][jNext] = steps;

                if (recurse(matrix, iNext, jNext, steps + 1)) {
                    return true;
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        return false;
    }

    private boolean isSafe(int[][] matrix, int i, int j) {
        return ((i >= 0) && (i < matrix.length) && (j >= 0) && (j < matrix[0].length)
                && (matrix[i][j] == -1));
    }
}
