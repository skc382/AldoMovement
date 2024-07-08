package shree.exp.Arrays.matrix;

import shree.exp.Utils;

/**
 * Created by shreedharkempanayakanahallichampakaram on 10/22/17.
 */
public class MatrixRotationVerification {

    public static void main(String[] args) {

        char[][] matrix =
                       {{'1', '2', '3', 'x'},
                        {'x', '1', '2', '3'},
                        {'3', 'x', '1', '2'},
                        {'2', '3', 'x', '1'}};

        MatrixRotationVerification m = new MatrixRotationVerification();
        Utils.printMatrix(matrix);
        System.out.println(m.matrix(matrix));
        Utils.printMatrix(matrix);
    }

    public boolean matrix(char[][] matrix) {

        StringBuilder rows = new StringBuilder();
        boolean result = false;

        for (int i = 0; i < matrix.length; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < matrix.length ; j++) {
                rows.append(String.valueOf(matrix[0][j]));
                row.append(String.valueOf(matrix[i][j]));
            }
            System.out.println(row);
            result = rows.toString().contains(row.toString());
        }
        System.out.println(rows.toString());

        return result;
    }
}
