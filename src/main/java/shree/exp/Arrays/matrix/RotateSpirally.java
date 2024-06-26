package shree.exp.Arrays.matrix;


import shree.exp.Utils;

/*
   https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 */
public class RotateSpirally {

    public static void main(String[] args) {
        char[][] matrix =
                       {{'1', '2', '3', 'x'},
                        {'4', '5', '6', 'y'},
                        {'7', '8', '9', 'z'},
                        {'a', 'b', 'c', 'd'}};

        RotateSpirally r = new RotateSpirally();
        r.rotate(matrix);
        Utils.printMatrix(matrix);
    }

    public void rotate(char[][] matrix) {
        rotatator(matrix, 0,0, matrix[0].length - 1, matrix.length - 1);
    }

    public void rotatator(char[][] matrix, int rowStart, int colStart, int rowEnd, int colEnd) {

        if(rowStart >= rowEnd || colStart >= colEnd) {
            return;
        }

        char prev = matrix[rowStart][colStart];

        for (int k = colStart + 1; k <= colEnd; k++) {
            char curr = matrix[rowStart][k];
            matrix[rowStart][k] = prev;
            prev = curr;
        }

        for (int i = rowStart + 1; i <= rowEnd; i++) {
            char curr = matrix[i][colEnd];
            matrix[i][colEnd] = prev;
            prev = curr;
        }

        for (int k = colEnd - 1; k >= colStart; k--) {
            char curr = matrix[rowEnd][k];
            matrix[rowEnd][k] = prev;
            prev = curr;
        }

        for (int i = rowEnd - 1; i >= rowStart; i--) {
            char curr = matrix[i][colStart];
            matrix[i][colStart] = prev;
            prev = curr;
        }

        rotatator(matrix, rowStart+1,colStart + 1, rowEnd-1, colEnd-1);
    }
}
