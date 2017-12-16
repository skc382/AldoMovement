package shree.exp.trees.heaps;

public interface HeapInterface {

    void MinHeapify(int i);

    int parent(int i);

    int left(int i);

    int right(int i);

    int extractMin();

    void decreaseKey(int i, int new_val);

    int getMin();

    void deleteKey(int i);

    void insertKey(int k);
}
