package shree.exp.trees.heaps;

import shree.exp.Utils;

public class BinaryMinHeap implements HeapInterface{

    private int heap_size = 0;
    private final int capacity;
    private final int[] array;

    public BinaryMinHeap(int capacity) {
        this.capacity = capacity;
        this.array = new int[this.capacity];
    }

    @Override
    public void MinHeapify(int i) {
        int smallest = i;
        int l = left(i);
        int r = right(i);

        if(l < heap_size && array[l] < array[i]) {
            smallest = l;
        }

        if(r < heap_size && array[r] < array[smallest]) {
            smallest = r;
        }

        if(smallest != i) {
            Utils.swap(array, smallest, i);
            MinHeapify(smallest);
        }
    }

    @Override
    public int parent(int i) {
        return i/2;
    }

    @Override
    public int left(int i) {
        return (2*i)+1;
    }

    @Override
    public int right(int i) {
        return (2*i)+2;
    }

    @Override
    public int extractMin() {
        if(heap_size == 0) {
            System.out.println("Empty Heap");
        }

        int minimum = array[0];
        array[0] = array[heap_size-1];
        array[heap_size-1] = 0;
        heap_size--;

        MinHeapify(0);
        return minimum;
    }

    @Override
    public void decreaseKey(int i, int new_val) {
        if(heap_size < 1) {
            System.out.println("Empty Heap cannot find key to delete");
        }

        array[i] = array[i] - new_val;

        while(i != 0 && array[parent(i)] > array[i]) {
            Utils.swap(array, i, parent(i));
            i = parent(i);
        }
    }

    @Override
    public int getMin() {
        if(heap_size == 0) {
            System.out.println("Empty heap!!!");
            return -1;
        }

        return array[0];
    }

    @Override
    public void deleteKey(int i) {
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    @Override
    public void insertKey(int k) {
        if(capacity == heap_size) {
            System.out.println("Heap is full");
        }

        heap_size++;
        array[heap_size-1] = k;

        int i =heap_size-1;
        while(i != 0 && array[parent(i)] > array[i]) {
            Utils.swap(array, parent(i), i);
            i = parent(i);
        }
        System.out.println("Inserted at child position of: "+ i);
    }

    public void printHeap() {
        Utils.printArray(array);
    }

    public static void main(String[] args) {
        BinaryMinHeap h = new BinaryMinHeap(11);
        h.insertKey(3);
        h.insertKey(2);
        h.insertKey(15);
        h.insertKey(5);
        h.insertKey(4);
        h.insertKey(45);

        h.printHeap();

        h.deleteKey(2);

        h.printHeap();

        System.out.println("Extracted Min value in heap: "+ h.extractMin());

        h.printHeap();

        System.out.println("New min value is: "+ h.getMin());
    }
}
