package shree.exp.numbers;

/**
 * Created by schampakaram on 1/19/18.
 */
public class FindMissingNumberInArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6,7,8,9};
        findMethodOne(arr);
        findXORMethodOne(arr);
    }

    private static void findMethodOne(int[] arr) {

        int n = arr.length+1;
        int sumTN = n * (n+1) / 2;

        for (int i = 0; i < arr.length; i++) {
            sumTN = sumTN - arr[i];
        }

        System.out.println("Missing number method One is: "+ Math.abs(sumTN));
    }

    private static void findXORMethodOne(int[] arr) {

        int xor = 0;
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
            xor = xor ^ (arr[i]+1);
        }

        xor = xor ^ (arr[n-1]+1);

        System.out.println(xor);
    }
}
