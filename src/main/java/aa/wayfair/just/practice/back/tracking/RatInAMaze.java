package aa.wayfair.just.practice.back.tracking;

import scala.math.Ordering;
import shree.exp.Utils;

import java.util.ArrayList;

public class RatInAMaze {

    private static Move[] moves = {new Move(0, 1, 'R'),
            new Move(0, -1, 'L'),
            new Move(1, 0, 'D')
//            new Move(-1, 0, 'U')
    };

    public static void main(String[] args) {
        int maze[][] = {
                {1, 1, 0, 0},
                {0, 1, 0, 1},
                {1, 0, 0, 0},
                {1, 1, 1, 1}
        };
        ArrayList<String> allPaths = new ArrayList<>();
        explore(maze, 0, 0, "", allPaths);
        Utils.printArray(allPaths);
    }

    private static void explore(int[][] matrix, int i, int j, String currentPathSlate, ArrayList<String> allPaths) {
        if (i == matrix.length - 1 && j == matrix.length - 1) {
            // reached the dest
            if(currentPathSlate.isEmpty()) {
                allPaths.add("No solution");
            } else {
                allPaths.add(currentPathSlate.toString());
            }
            return;
        }

        for (int k = 0; k < moves.length; k++) {
            Move move = moves[k];
            if(move.tryMove(matrix, i, j)) {
                Move nextMove = move.performMove(i, j);
                explore(matrix, nextMove.i, nextMove.j, currentPathSlate + nextMove.direction, allPaths);
            }
        }
    }

    private static boolean isValidPath(int[][] matrix, int i, int j) {
        boolean isInBoundry = ((i >= 0) && (i < matrix.length) && (j >= 0) && (j < matrix[0].length));
        return isInBoundry && (matrix[i][j] == 1);
    }

    static class Move {
        int i, j;
        char direction;

        public Move(int i, int j, char direction) {
            this.i = i;
            this.j = j;
            this.direction = direction;
        }

        public boolean tryMove(int[][] matrix, int i, int j) {
            return isValidPath(matrix, this.i + i, this.j + j);
        }

        public Move performMove(int i, int j) {
            return new Move(this.i + i, this.j + j, this.direction);
        }

    }
}
