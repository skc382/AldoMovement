package shree.exp.DynamicProgramming;

/**
 * Created by shreedharkempanayakanahallichampakaram on 10/10/17.
 */
public class LongestIncreasingSubSequence {

    public static void main(String[] args) {
        int[] input = {1, 3, 54, 40, 45, 67, 8, 90};
        int[] helper = new int[input.length];

        for (int i = 0; i < helper.length; i++) {
            helper[i] = 1;
        }

        fun(input, helper, input.length-1);

        System.out.println(helper[helper.length-1]);
    }

    private static void fun(int[] input, int[] helper, int maxIndex) {

        if(maxIndex <= 0) {
            helper[0] = 1;
            return;
        }

        fun(input, helper, maxIndex-1);

        for (int i = maxIndex-1; i >= 0; i--) {
            if(input[maxIndex] > input[i]) {
                helper[maxIndex] = helper[i] + 1;
                return;
            }
        }
    }
}

