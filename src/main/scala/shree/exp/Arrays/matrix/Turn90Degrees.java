package shree.exp.Arrays.matrix;


import shree.exp.Utils;

public class Turn90Degrees {

    public static void main(String[] args) {
        char[][] matrix =
                {{'1','2','3','^'},
                {'4','5','6','|'},
                {'7','8','9','|'},
                {'a','b','c','|'}};

        Turn90Degrees t = new Turn90Degrees();
        char[][] result = t.rotate90(matrix);
        Utils.printMatrix(result);

    }

    public char[][] rotate90(char[][] matrix) {
        int columns = matrix.length;
        int rows = matrix[0].length;
        char[][] buffer = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                buffer[j][(columns - 1) - i] = matrix[i][j];
            }
        }

        return buffer;
    }
}
