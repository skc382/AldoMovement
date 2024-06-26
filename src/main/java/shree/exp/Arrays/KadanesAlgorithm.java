package shree.exp.Arrays;

/**
 * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 */
public class KadanesAlgorithm {


    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        System.out.println(maxSum(arr));
        maxSoFar(arr);
    }

    private static int maxSum(int[] arr) {

        int max_ending_here = 0;
        int max_so_far = 0;

        for(int i=0; i<arr.length; i++) {
            max_ending_here = max_ending_here + arr[i];

            if(max_ending_here < 0) {
                max_ending_here = 0;
            }

            if(max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
            }
        }

        return max_so_far;
    }

    private static void maxSoFar(int[] arr) {

        int max_ending_here = 0,max_so_far = 0,
                start = 0, end = 0, s = 0;

        for (int i = 0; i < arr.length; i++) {
            max_ending_here = max_ending_here + arr[i];

            if(max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }

            if(max_ending_here < 0) {
                max_ending_here = 0;
                s = i+1;
            }
        }

        System.out.println("max-value: "+ max_so_far);
        System.out.println("start: "+ start +" and end: "+ end);
    }
}
