package shree.exp.LinkedList;


import shree.exp.Utils;
import shree.exp.trees.heaps.HeapInterface;

public class MergeKSortedListsHeapVersion {

    public static void main(String[] args) {

        int[][] sortedArrays = {{2,4,6,8,10},
                {1,3,5,70,9},
                {23,34,7,32,45}};
        int m = sortedArrays.length;
        int n = sortedArrays[0].length;

        Heap heap = new Heap(m*n);
        int[] result = new int[m*n];

        for (int i = 0; i < sortedArrays.length ; i++) {
            for (int j = 0; j < sortedArrays[0].length ; j++) {
                int curr = sortedArrays[i][j];
                heap.insertKey(curr);
            }
        }

        int i =0;
        while(heap.getMin() != -1) {
            int curr = heap.extractMin();
            result[i] = curr;
            i++;
        }

        Utils.printArray(result);
    }

   static class Heap implements HeapInterface {

        private final int[] arr;
        private int heap_size;

        public void printHeap() {
            Utils.printArray(arr);
        }

        public Heap(int capacity) {
            this.arr = new int[capacity];
            this.heap_size = 0;
        }

        @Override
        public void MinHeapify(int i) {

            int left = left(i);
            int right = right(i);
            int smallest = i;

            if(left < heap_size && arr[left] < arr[smallest]) {
                smallest = left;
            }

            if(right < heap_size && arr[right] < arr[smallest]) {
                smallest = right;
            }

            if(smallest != i) {
                Utils.swap(arr, i, smallest);
                MinHeapify(smallest);
            }
        }

        @Override
        public int parent(int i) {
            return i/2;
        }

        @Override
        public int left(int i) {
            return 2*i + 1;
        }

        @Override
        public int right(int i) {
            return 2*i + 2;
        }

        @Override
        public int extractMin() {
            int toReturn = arr[0];

            arr[0] = arr[heap_size-1];
            arr[heap_size-1] = -1;
            heap_size--;
            MinHeapify(0);

            return toReturn;
        }

        @Override
        public void decreaseKey(int i, int new_val) {
            arr[i] = arr[i] - new_val;

            while(i >= 0 && arr[parent(i)] > arr[i]) {
                Utils.swap(arr, i, parent(i));
                i = parent(i);
            }
        }

        @Override
        public int getMin() {
            return arr[0];
        }

        @Override
        public void deleteKey(int i) {
            decreaseKey(i, Integer.MIN_VALUE);
            extractMin();
        }

        @Override
        public void insertKey(int k) {
            heap_size++;
            arr[heap_size-1] = k;

            int i = heap_size-1;
            while(i >= 0 && arr[i] < arr[parent(i)]) {
                Utils.swap(arr, i, parent(i));
                i = parent(i);
            }
        }
    }
}
