package shree.exp.Arrays.Rotation;

import shree.exp.Utils;

/**
 * Created by shreedharkempanayakanahallichampakaram on 10/22/17.
 */
public class Reversal {

    public static void main(String[] args) {
        int[] arr = {3,4,2,7,8,12,34,9};

        Reversal r = new Reversal();
        r.reversal(arr);
        Utils.printArray(arr);
    }

    public void reversal(int[] arr) {
        int i = 0;
        int j = arr.length - 1;

        while(i < j) {
            Utils.swap(arr, i , j);
            i++;
            j--;
        }
    }
}
