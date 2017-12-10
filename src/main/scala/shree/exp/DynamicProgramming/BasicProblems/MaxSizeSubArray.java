package shree.exp.DynamicProgramming.BasicProblems;

import shree.exp.Utils;

import java.util.Arrays;

public class MaxSizeSubArray {

    public static void main(String[] args) {
        int M[][] =  {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};

        maxSubArry(M);
    }

    private static void maxSubArry(int[][] matrix) {

        int[][] s = new int[matrix.length][matrix[0].length];

        //set first row of s
        for (int i = 0; i < s[0].length && i < matrix[0].length ; i++) {
            s[0][i] = matrix[0][i];
        }

        //set first row of s
        for (int i = 0; i < s.length && i < matrix.length; i++) {
            s[i][0] = matrix[i][0];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1) {
                    int min = min(s, i, j);
                    System.out.println(String.format("i=%d; j=%d; min=%d", i, j, min));
                    s[i][j] =  min + 1;
                } else if(matrix[i][j] == 0) {
                    s[i][j] = 0;
                }
            }
        }

       // -- To be continued

        Utils.printMatrix(s);

    }

    private static int min(int[][] matrix, int i, int j) {

        if(i >= 0 && i < matrix.length && j >=0 && j < matrix[0].length) {

            int left = Integer.MAX_VALUE, leftTop = Integer.MAX_VALUE, top = Integer.MAX_VALUE;

            if(isInBounds(j-1, matrix[0].length)) {
                left = matrix[i][j-1];
            }

            if(isInBounds(i-1, matrix.length)) {
                top = matrix[i-1][j];
            }

            if(isInBounds(i-1, matrix.length) && isInBounds(j-1, matrix[0].length)) {
                leftTop = matrix[i-1][j-1];
            }

            int[] mins = {left, leftTop, top};
            return Arrays.stream(mins).min().getAsInt();
        }

        throw new RuntimeException("blah");

    }

    private static boolean isInBounds(int index, int length) {
        return index >= 0 && index < length;
    }

}
