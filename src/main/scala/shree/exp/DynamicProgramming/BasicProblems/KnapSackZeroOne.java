package shree.exp.DynamicProgramming.BasicProblems;

/**
 * Created by shreedharkempanayakanahallichampakaram on 12/10/17.
 */
public class KnapSackZeroOne {

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int  W = 50;
        int n = val.length;
        System.out.println(naive(val, wt, W , n));
        System.out.println(topDownDP(val, wt, W));
    }

    private static int naive(int[] v, int[] wt, int W, int n) {

        if(W == 0 |  n == 0) {
            return 0;
        }

        if(n > W) {
            return 0;
        }

        return Math.max(naive(v, wt, W, n-1),
                (v[n-1] + naive(v, wt, W-wt[n-1], n-1)));
    }

    // Redo this again and again: https://www.youtube.com/watch?v=8LusJS5-AGo&t=298s
    // http://www.geeksforgeeks.org/knapsack-problem/
    private static int topDownDP(int[] v, int[] w, int W) {

        int[][] matrix =  new int[v.length+1][W+1];

        for(int i=0; i <= v.length; i++) {
            for (int j = 0; j <= W ; j++) {
                if(i == 0 || j == 0) {
                    matrix[i][j] = 0;
                } else if(w[i-1] > j) {
                    matrix[i][j] = matrix[i-1][j];
                } else {
                    matrix[i][j] = Math.max((v[i-1] + matrix[i-1][j-w[i-1]]), matrix[i-i][j]);
                }
            }
        }

        return matrix[v.length][W];
    }
}
