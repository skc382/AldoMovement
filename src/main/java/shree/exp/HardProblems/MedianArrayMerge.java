package shree.exp.HardProblems;

// Given two arrays find the median of the combined array with a complexity of O(log(m+n)).

import shree.exp.SortingSearching.MergeSort;
import shree.exp.SortingSearching.Quicksort;
import shree.exp.Utils;

public class MedianArrayMerge {


    public static void main(String[] args) {
        int[] largeArray = {5, 12, 23, 34, 45, 68, 90, 210};
        int[] smallArray = {10, 21, 32, 59, 78, 108, 111};

        // int[] {5, 10, 12, 21, 23, 32, 34, 45, 59, 68, 78, 90, 108, 111, 210}

        MedianArrayMerge m = new MedianArrayMerge();
        int result = m.findMedian(largeArray, smallArray, 0, largeArray.length-1, 0, smallArray.length-1);

        System.out.println("Result is: "+ result);
    }

    private int findMedian(int[] largeArray, int[] smallArray, int largeStart, int largeEnd, int smallStart, int smallEnd) {

        if(largeEnd < largeStart && smallEnd < smallStart) {
            return -1;
        }

        if((largeEnd - largeStart) < 2 || (smallEnd - smallStart) < 2) {
            // call merge
           return merge(largeArray, smallArray, largeStart, largeEnd, smallStart, smallEnd);
        }

        //Find Median
        double mLInde = (largeStart + largeEnd) / 2.0;
        double mSInde = (smallStart + smallEnd) / 2.0;


        int mLIndex = (int) Math.ceil(mLInde);
        int mSIndex = (int) Math.ceil(mSInde);

        int mL = largeArray[mLIndex];
        int mS = smallArray[mSIndex];

        //
        if(mL == mS) {
            // return median
            return mL;
        }

        if(mL < mS) {
            // Now the small array median is towards the right of the largeArray
            // So the median is between left half of the large array and right half of the small array
            return findMedian(largeArray, smallArray, mLIndex, largeEnd, smallStart, mSIndex);
        } else {
            return findMedian(largeArray, smallArray, largeStart, mLIndex, mSIndex, smallEnd);
        }
    }

    private int merge(int[] largeArray, int[] smallArray, int largeStart, int largeEnd, int smallStart, int smallEnd) {
        int[] helper = new int[((largeEnd - largeStart) + 1) + ((smallEnd - smallStart) + 1)];

        int i = 0;
        while (largeStart <= largeEnd) {
            helper[i] = largeArray[largeStart];
            i++;
            largeStart++;
        }

        while (smallStart <= smallEnd) {
            helper[i] = smallArray[smallStart];
            i++;
            smallStart++;
        }

        (new MergeSort()).mergeSort(helper, new int[helper.length], 0, helper.length-1);

        Utils.printArray(helper);

        double midDouble = (helper.length-1) / 2.0;
        int mid = (int) Math.floor(midDouble);
        return helper[mid];
    }
}
