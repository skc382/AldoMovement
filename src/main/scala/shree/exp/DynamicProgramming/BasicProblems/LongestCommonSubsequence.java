package shree.exp.DynamicProgramming.BasicProblems;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String one = "abcdaf";
        String two = "acbcf";

        System.out.println("Length: "+ lcs(one, two));
    }

    private static int lcs(String one, String two) {

        char[] oneArry = one.toCharArray();
        char[] twoArry = two.toCharArray();

        int[][] matrix = new int[oneArry.length+1][twoArry.length+1];

        for (int i = 1; i <= oneArry.length; i++) {
            for (int j = 1; j <= twoArry.length ; j++) {
                if(oneArry[i-1] == twoArry[j-1]) {
                    System.out.print(oneArry[i-1]+", ");
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }

        return matrix[oneArry.length][twoArry.length];
    }
}
