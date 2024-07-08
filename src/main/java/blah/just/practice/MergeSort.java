package blah.just.practice;

import shree.exp.Utils;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(45,2,5,67,1,32);
        mergeSort(arr, 0, arr.size()-1);

        Utils.printArray(arr);
    }

    private static void mergeSort(List<Integer> arry, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(arry, start, mid);
        mergeSort(arry, mid+1, end);

        // merge phase
        int i = start;
        int j = mid+1;

        ArrayList<Integer> helper = new ArrayList<>();
        while(i <= mid && j <= end) {
            if(arry.get(i) < arry.get(j)) {
                helper.add(arry.get(i));
                i++;
            } else if(arry.get(j) < arry.get(i)) {
                helper.add(arry.get(j));
                j++;
            }
            else {
                helper.add(arry.get(i));
                helper.add(arry.get(j));
                j++;
                i++;
            }

        }

        while(i <= mid) {
            helper.add(arry.get(i));
            i++;
        }

        while(j <= end) {
            helper.add(arry.get(j));
            j++;
        }

        int y=start;
        for (int x = 0; x < helper.size() && y <= end; x++) {
            arry.set(y, helper.get(x));
            y++;
        }
    }
}
