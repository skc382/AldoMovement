package shree.exp.BackTracking;

import java.util.function.BiFunction;

/**
 * Created by shreedharkempanayakanahallichampakaram on 12/10/17.
 */
public class KnightTourProblem {


//    BiFunction<Integer, Integer, Boolean> isSafe = (x, y) ->  ((x >= 0) && (x < N) && (y >= 0) && (y < N) && matrix[x][y] == -1);

    private void tour() {

        int N = 8;

        int[][] matrix = new int[N][N];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = -1;
            }
        }



        matrix[0][0] = 0;



    }

    private boolean recurse(int[][] matrix) {

        return false;
    }
}
