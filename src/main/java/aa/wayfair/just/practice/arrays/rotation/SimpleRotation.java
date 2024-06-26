package aa.wayfair.just.practice.arrays.rotation;

import shree.exp.Utils;

public class SimpleRotation {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};

        leftRotate(arr, 2);
        Utils.printArray(arr);

        System.out.println();
        rightRotate(arr, 4);
        Utils.printArray(arr);
    }

    private static void leftRotate(int[] arr, int numberOfRotations) {
        for (int i = 0; i < numberOfRotations; i++) {
            int temp = arr[0];

            for (int j = 1; j < arr.length; j++) {
                arr[j-1] = arr[j];
            }
            arr[arr.length - 1] = temp;
        }
    }

    private static void rightRotate(int[] arr, int numberOfRotations) {
        for (int i = 0; i < numberOfRotations; i++) {
            int temp = arr[arr.length-1];

            for (int j = arr.length-2; j >= 0; j--) {
                arr[j+1] = arr[j];
            }
            arr[0] = temp;
        }
    }
}
