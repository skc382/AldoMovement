package shree.exp.Arrays;

/**
 * Created by schampakaram on 1/16/18.
 */
public class FirstOccurenceInAnSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,2,2,3,3,3,3,3,3,3,4,4,4,4,4, 4, 4,5,6};

        System.out.println(BS(arr, 0, arr.length-1, 4));
    }

    private static int BS(int[] arr, int low, int high, int element) {

        if(low < 0 || high > arr.length-1) {
            return -1;
        }

        int mid = (low + high) / 2;

        if(arr[mid] == element) {

            int prev = mid-1;
            if(prev > 0 && arr[prev] == element) {
                return BS(arr, low, mid, element);
            }

            return mid;
        }

        if(element < arr[mid]) {
            return BS(arr, low, mid, element);
        }

        return BS(arr, mid, high, element);
    }
}
