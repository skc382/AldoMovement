package aa.wayfair.just.practice.arrays;

public class FirstOccurrenceInAnSortedArray {

    public static void main(String[] args) {
        int[] arr = {1,2,2,2,2,2,3,3,3,3,3,3,3,3,4,4,4,4,4, 4, 4,5,6};

        System.out.println(findWithBs(arr, 0, arr.length-1, 4));
    }

    private static int findWithBs(int[] arr, int start, int end, int element) {
        if(start < 0 || end > arr.length-1) {
            return -1;
        }

        int mid = (start + end) / 2;

        if(arr[mid] == element) {
            int prev = mid -1;
            if(prev > 0 && arr[prev] == element) {
                return findWithBs(arr, start, mid, element);
            }
            return mid;
        }

        if(element < arr[mid] ) {
            return findWithBs(arr, start, mid, element);
        } else {
            return findWithBs(arr, mid, end, element);
        }
    }
}
