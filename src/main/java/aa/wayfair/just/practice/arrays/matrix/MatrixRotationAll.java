package aa.wayfair.just.practice.arrays.matrix;

import shree.exp.Utils;

public class MatrixRotationAll {

    public static void main(String[] args) {
        char[][] matrix =
                {
                        {'1', '2', '3', 'x'},
                        {'4', '5', '6', 'y'},
                        {'7', '8', '9', 'z'},
                        {'a', 'b', 'c', 'd'}};
//        rotator(matrix, 0, matrix.length-1, matrix[0].length-1);
//        rotateWithExtraSpaceAntiClockWise(matrix);
        rotateWithExtraSpaceClockWise(matrix);
    }

    private static void rotateWithExtraSpaceClockWise(char[][] matrix) {
        // Optimized for time, use extra space
        char[][] aux = new char[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
//                0,0 => 0,3 | 0,1 => 1,3 | 0,2=> 2,3

                aux[j][(matrix.length - 1) - i] = matrix[i][j];
            }
        }
        Utils.printMatrix(aux);
    }

    private static void rotateWithExtraSpaceAntiClockWise(char[][] matrix) {
        // Optimized for time, use extra space
        char[][] aux = new char[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
//                0,1 => 2,0
                aux[(matrix.length - 1) - j][i] = matrix[i][j];
            }
        }
        Utils.printMatrix(aux);
    }
    private static void rotator(char[][] matrix, int start, int rowEnd, int columnEnd) {
        // Inplace - Optimized for space
        if(start >= rowEnd && start >= columnEnd) {
            return;
        }

        char prev = matrix[start][start];
        char curr;
        for (int i = start+1; i <= columnEnd ; i++) {
            curr = matrix[start][i];
            matrix[start][i] = prev;
            prev = curr;
        }

        for (int i = start+1; i <= rowEnd ; i++) {
            System.out.printf("%d, %d |", i, rowEnd);
            curr = matrix[i][columnEnd];
            matrix[i][columnEnd] = prev;
            prev = curr;
        }
        System.out.println();

        for (int i = columnEnd-1; i >= start; i--) {
            curr = matrix[rowEnd][i];
            matrix[rowEnd][i] = prev;
            prev = curr;
        }

        for (int i = rowEnd-1; i >= start; i--) {
            curr = matrix[i][start];
            matrix[i][start] = prev;
            prev = curr;
        }

        rotator(matrix, start+1, rowEnd-1, columnEnd-1);
        Utils.printMatrix(matrix);
    }
}
