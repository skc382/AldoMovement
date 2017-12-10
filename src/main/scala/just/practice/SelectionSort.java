package just.practice;

import shree.exp.Utils;

/**
 * Created by shreedharkempanayakanahallichampakaram on 10/28/17.
 */
public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = {2,45,5,67,1,32};

        selectionSort(arr);
        Utils.printArray(arr);
    }

    private static void selectionSort(int[] arr) {
        int minValue = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if(arr[j] < minValue) {
                    minValue = arr[j];
                    minIndex = j;
                }
            }
            Utils.swap(arr, i, minIndex);
        }


    }
}
