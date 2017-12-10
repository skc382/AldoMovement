package shree.exp.SortingSearching;


import shree.exp.Utils;

public class Quicksort {

    public static void main(String[] args) {
        int[] array = {32, 90, 4, 12, 9};
        Quicksort q = new Quicksort();
        q.quickSort(array, 0, array.length - 1);

        Utils.printArray(array);
    }

    public void quickSort(int[] array, int left, int right) {
        int index = partition(array, left, right);
        if(left < index-1) {
            quickSort(array, left, index-1);
        }

        if(index < right) {
            quickSort(array, index, right);
        }
    }

    private int partition(int[] array, int left, int right) {
        int pivotIndex = (left + right) / 2;
        int pivot = array[pivotIndex];

        while (left <= right) {

            while (array[left] < pivot) left++;

            while (array[right] > pivot) right--;

            if(left <= right) {
                Utils.swap(array, left, right);
                left++;
                right--;
            }
        }

        return left;
    }



}