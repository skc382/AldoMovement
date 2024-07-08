package shree.exp.DynamicProgramming.BasicProblems;

import shree.exp.Utils;

/**
 * https://www.youtube.com/watch?v=We3YDTzNXEk&t=333s
 */
public class EditDistance {

    public static void main(String[] args) {
        char[] from = "abcdef".toCharArray();
        char[] to = "azced".toCharArray();

        System.out.println("Edit distance is: "+ editDistance(from, to));
    }

    private static int editDistance(char[] from, char[] to) {

        int[][] matrix = new int[to.length+1][from.length+1];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = i;
        }

        for (int i = 0; i < matrix[0].length; i++) {
            matrix[0][i] = i;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {

                if(from[j-1] == to[i-1]) {

                    matrix[i][j] = matrix[i-1][j-1];
                } else {
                    matrix[i][j] = 1 + Math.min(matrix[i-1][j], Math.min(matrix[i-1][j-1], matrix[i][j-1]));
                }
            }
        }

        Utils.printMatrix(matrix);
        return matrix[to.length][from.length];

    }
}
