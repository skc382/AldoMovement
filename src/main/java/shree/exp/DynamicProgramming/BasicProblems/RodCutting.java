package shree.exp.DynamicProgramming.BasicProblems;


import shree.exp.Utils;

public class RodCutting {

    public static void main(String[] args) {
        int[] values = {2,5,7,8};
        int[] rods = {1,2,3,4};
        int n = 5;

        System.out.println("Max rod cutting: "+ rodCutting(values, rods, n));
    }

    private static int rodCutting(int[] values, int[] rods, int n) {

        int[][] matrix = new int[rods.length+1][n+1];

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {

                if(j < rods[i-1]) {
                    matrix[i][j] = matrix[i][j-1];
                } else if(j == rods[i-1]) {
                    matrix[i][j] = values[i-1];
                } else if(j > rods[i-1]) {
                    matrix[i][j] = Math.max(matrix[i][j-i] + values[i-1], matrix[i-1][j]);
                }
            }
        }

        Utils.printMatrix(matrix);
        return matrix[rods.length][n];
    }
}
