package shree.exp.trees.heaps;


// -- hint leaf nodes in a heap come after (n-2)/2
public class isArrayHeap {

    public static void main(String[] args) {
        int arr[] = {90, 15, 10, 7, 12, 2, 7, 3};

        if(isArrayHeap(arr, 0)) {
            System.out.println("This array is a heap");
        } else {
            System.out.println("This array is NOT a heap");
        }

        if(isArrayHeapIterative(arr)) {
            System.out.println("This array is a heap");
        } else {
            System.out.println("This array is NOT a heap");
        }
    }

    private static boolean isArrayHeap(int[] arr, int i) {
        int n = arr.length-1;

        if(i > (n-2) / 2) {
            return true;
        }

        if(arr[i] >= arr[2*i + 1] && arr[i] >= arr[2*i + 2]
                && isArrayHeap(arr, (2*i + 1)) && isArrayHeap(arr, (2*i + 2))) {
            return true;
        }

        return false;
    }

    private static boolean isArrayHeapIterative(int[] arr) {

        boolean isHeap = true;
        for (int i = 0; i < (arr.length - 2)/2; i++) {

            if(!(arr[i] >= arr[2*i+1] && arr[i] >= arr[2*i + 2])) {
                isHeap = false;
            }
        }

        return isHeap;
    }

}
