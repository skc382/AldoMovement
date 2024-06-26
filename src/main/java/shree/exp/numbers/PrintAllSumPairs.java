package shree.exp.numbers;

import java.util.HashMap;


public class PrintAllSumPairs {

    public static void main(String[] args) {
        int[] arr = {3,4,6,5,5,10};

        printSum(arr, 10);
    }

    private static void printSum(int[] arr, int sum) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++) {
            int key = arr[i];
            Integer count;
            if((count = map.get(key)) == null) {
                map.put(key, 1);
            } else {
                count = count + 1;
                map.put(key, count);
            }
        }

        System.out.println("Pairs:-");
        for(int i=0; i<arr.length && arr[i] < sum; i++) {
            int remainder = sum - arr[i];

            Integer count;
            if((count = map.get(remainder)) != null) {
                while(count != 0) {
                    System.out.println(String.format("(%d,%d)", arr[i], remainder));
                    count--;
                }
            }
        }

    }
}
