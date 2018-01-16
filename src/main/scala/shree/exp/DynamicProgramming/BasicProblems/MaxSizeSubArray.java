package shree.exp.DynamicProgramming.BasicProblems;

public class MaxSizeSubArray {

    public static void main(String[] args) {
        int M[][] =  {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};

        System.out.println("MAX-SIZE: "+ maxSubArry(M));
    }

    private static int maxSubArry(int[][] matrix) {

        int[][] arr = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1) {
                    arr[i][j] = getMinVal(matrix, i, j) + 1;
                } else {
                    arr[i][j] = 0;
                }

            }
        }

        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(arr[i][j]+", ");
                if(arr[i][j] > maxValue) {
                    maxValue = arr[i][j];
                }
            }
            System.out.println();
        }

        return maxValue;

    }

    private static int getMinVal(int[][] matrix, int i, int j) {
        int[] values = new int[3];

        values[0] = getVal(matrix, i, j-1);
//        values[1] = getVal(matrix, i-1, j-1);
//        values[2] = getVal(matrix, i-1, j);

        int min = Integer.MAX_VALUE;
        for (int k = 0; k < values.length ; k++) {
            if(values[k] < min) {
                min = values[k];
            }
        }

        return min;
    }

    private static int getVal(int[][] matrix, int i, int j) {

        if(i >= 0 && i <= matrix.length-1 && j >= 0 &&j <= matrix[0].length-1) {
            return matrix[i][j];
        }

        return Integer.MAX_VALUE;
    }

}
