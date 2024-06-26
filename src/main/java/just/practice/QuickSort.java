package just.practice;

import shree.exp.Utils;

/**
 * Created by shreedharkempanayakanahallichampakaram on 10/28/17.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {2,45,5,67,1,32};
        quickSort(arr, 0, arr.length-1);

        Utils.printArray(arr);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if(left < right) {

            int index = partition(arr, left, right);

            if(left <= index-1) {
                quickSort(arr, left, index-1);
            }

            if(index <= right) {
                quickSort(arr, index, right);
            }
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left+right)/2];

        while(left<=right) {

            while(arr[left] < pivot) left++;

            while(arr[right] > pivot) right--;

            if(left<=right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }

        return left;
    }
}
