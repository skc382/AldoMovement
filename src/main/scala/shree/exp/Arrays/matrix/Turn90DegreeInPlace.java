package shree.exp.Arrays.matrix;

import shree.exp.Utils;

/**
 * Created by shreedharkempanayakanahallichampakaram on 10/22/17.
 */
public class Turn90DegreeInPlace {

    public static void main(String[] args) {
        char[][] matrix =
                       {{'1', '2', '3', 'x'},
                        {'4', '5', '6', 'y'},
                        {'7', '8', '9', 'z'},
                        {'a', 'b', 'c', 'd'}};

        Turn90DegreeInPlace t = new Turn90DegreeInPlace();
//        t.methodOne(matrix, 0, 0, matrix[0].length - 1, matrix.length-1);
        t.transposeMethod(matrix);
        Utils.printMatrix(matrix);

    }

    public void methodOne(char[][] matrix, int rowStart, int colStart, int rowEnd, int  colEnd) {

        char prev;
        char curr;

        if(rowStart >= rowEnd || colStart >= colEnd) {
            return;
        }

            int i = rowStart;
            for (int j = colStart; j <= colEnd; j++) {
                prev = matrix[i][j];

                curr = matrix[j][colEnd];
                matrix[j][colEnd] = prev;
                prev = curr;

                curr = matrix[rowEnd][colEnd - j];
                matrix[rowEnd][colEnd - j] = prev;
                prev = curr;

                curr = matrix[rowEnd - j][colStart];
                matrix[rowEnd - j][colStart] = prev;

                matrix[i][j] = curr;
            }

        methodOne(matrix, rowStart + 1, colStart + 1, rowEnd - 1, colEnd - 1);
    }

    public void transposeMethod(char[][] matrix) {

        //Transpose
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                char temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse columns
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0, k = matrix.length - 1; j < k; j++, k--) {
                char temp = matrix[j][i];
                matrix[j][i] = matrix[k][i];
                matrix[k][i] = temp;
            }
        }
    }
}
