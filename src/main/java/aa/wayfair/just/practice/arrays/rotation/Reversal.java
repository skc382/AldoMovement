package aa.wayfair.just.practice.arrays.rotation;

import shree.exp.Utils;

public class Reversal {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        for(int i=0, j=arr.length-1; i<=j; i++, j--) {
            Utils.swap(arr, i, j);
        }

        Utils.printArray(arr);
    }
}
