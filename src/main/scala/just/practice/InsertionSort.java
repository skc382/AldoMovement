package just.practice;


import shree.exp.Utils;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {2,45,5,67,1,32};

        insertionSort(arr);
        Utils.printArray(arr);
    }

    private static void insertionSort(int[] arr) {

        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] <= minValue) {
                int prev = arr[0], next = 0;
                arr[0] = arr[i];
                minValue = arr[i];

                for (int j = 1; j <= i ; j++) {
                    next = arr[j];
                    arr[j] = prev;
                    prev = next;
                }
            }
        }

    }
}
