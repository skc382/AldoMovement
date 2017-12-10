package just.practice;

import shree.exp.Utils;

/**
 * Created by shreedharkempanayakanahallichampakaram on 10/28/17.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {2,45,5,67,1,32};

        bubbleSort(arr);
        Utils.printArray(arr);
    }

    private static void bubbleSort(int[] arr) {

        boolean noSwaps = false;
        while(!noSwaps) {
            noSwaps = true;
            for (int j = 0; j < arr.length-1 ; j++) {
                if(arr[j] > arr[j+1]) {
                    noSwaps = false;
                    Utils.swap(arr, j, j+1);
                }
            }
        }
    }
}
