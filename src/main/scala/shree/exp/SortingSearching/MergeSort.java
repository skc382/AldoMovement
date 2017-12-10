package shree.exp.SortingSearching;


import shree.exp.Utils;

public class MergeSort {


    public static void  main(String[] args) {

        int[] array = {120, 212, 213, 12};
        int[] helper = new int[array.length];

        MergeSort m = new MergeSort();
        m.mergeSort(array, helper, 0, array.length-1);

        Utils.printArray(array);
    }

    public void mergeSort(int[] array, int[] helper, int low, int high) {
        if(low < high) {
            int mid = (low + high) / 2;
            mergeSort(array, helper, low, mid);
            mergeSort(array, helper, mid+1, high);
            merge(array, helper, low, mid, high);
        }
    }

    private void merge(int[] array, int[] helper, int low, int mid, int high) {

        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = mid + 1;
        int current = low;

        while (helperLeft <= mid && helperRight <= high) {
            if(helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else {
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        int remaining = mid - helperLeft;
        for (int i = 0; i <= remaining ; i++) {
            array[current+i] = helper[helperLeft + i];
        }
    }
}
