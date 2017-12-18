package shree.exp.Arrays.Rearrangement;

import shree.exp.Utils;

/**
 * http://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers-publish/
 *
 * [-1, 2, -3, 4, 5, 6, -7, 8, 9]
 */
public class ReArrangePosNegativeNumbers {

    public static void main(String[] args) {
        int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        int n = arr.length;
        rearrange(arr);
        System.out.println("Array after rearranging: ");
        Utils.printArray(arr);
    }

    private static void rearrange(int[] arr) {
        int pivot = 0;

        int i = 0, j = arr.length-1;

        while( i < j) {

            while( arr[i] < pivot) i++;

            while( arr[j] > pivot) j--;

            if(i < j) {
                Utils.swap(arr, i, j);
            }
        }

        int neg = 0, pos = i;

        while(pos < arr.length && neg < pos && arr[neg] < pivot) {

            Utils.swap(arr, pos, neg);
            pos++;
            neg += 2;
        }
    }
}
