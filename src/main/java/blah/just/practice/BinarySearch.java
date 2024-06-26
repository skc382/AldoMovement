package blah.just.practice;

import java.util.ArrayList;

public class BinarySearch {

    public static void main(String[] args) {
        int[] in =  {};
        int result= doBinarySearch(in, 1, 0, in.length-1);
        System.out.println("result is: " + result);
    }

    static int doBinarySearch(int[] input, int item, int start, int end) {
        if(start > end) {
            return -1;
        }

        if(input[start] == item) {
            return start;
        }

        int mid = (start + end) / 2;

        if(input[mid] == item) {
            return mid;
        }
        else if(input[mid] > item) {
            return doBinarySearch(input, item, start, mid);
        } else {
            return doBinarySearch(input, item, mid+1, end);
        }
    }
}