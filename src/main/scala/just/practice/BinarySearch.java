package just.practice;

/**
 * Created by shreedharkempanayakanahallichampakaram on 10/27/17.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {12,14,15,17,45,50,60};

        int index = binarySearch(arr, 0, arr.length-1, 15);

        System.out.println(index);
    }

    private static int binarySearch(int[] arr, int left, int right, int value) {

        int mid = (left + right) / 2;

        if(value == arr[mid]) {
            return mid;
        }

        if(left >= right) {
            return -1;
        }

        if(value < arr[mid]) {
            return  binarySearch(arr, left, mid, value);
        } else {
            return binarySearch(arr, mid+1, right, value);
        }
    }
}
