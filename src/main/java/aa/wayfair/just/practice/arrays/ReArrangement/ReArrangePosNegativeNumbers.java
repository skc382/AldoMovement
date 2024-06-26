package aa.wayfair.just.practice.arrays.ReArrangement;

import shree.exp.Utils;

public class ReArrangePosNegativeNumbers {

    public static void main(String[] args) {
        int[] arr = {-1, 3, -2, -4, 7, -5};
        rearrange(arr);
        Utils.printArray(arr);
    }

    private static void rearrange(int[] arr) {
        boolean flag = isPositive(arr[0]);

        // flip
        flag = !flag;

        int tracker = 1;
        int forward = 1;
        while(forward < arr.length) {

            if(flag == isPositive(arr[forward])) {
                swap(arr, forward, tracker);
                flag = !flag;
                tracker++;
            }
            forward++;
        }

    }

    private static void  swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private static boolean isPositive(int x) {
        return (x >= 0);
    }

}
