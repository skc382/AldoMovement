package shree.exp.stacks;


public class BasicQ {

    int front, rear, size;
    int capacity;
    int[] arr;

    public BasicQ() {
        this.front = 0;
        this.rear = 0;
        this.size = 0;
        this.capacity = 50;
        this.arr = new int[capacity];

        for (int i = 0; i < arr.length ; i++) {
            arr[i] = -2;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isFull() {
        return (size == capacity);
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void enqueue(int item) {
        if (isFull()) {
            throw new RuntimeException("Q is full");
        }

        arr[rear] = item;
        rear = (rear + 1) % capacity;
        size = size + 1;
    }

    public void print() {
        for (int i = front; i <= rear ; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println();
    }

    public int dequeue() {
        if(isEmpty()) {
            return -1;
        }

        int toReturn = arr[front];
        front = (front + 1) % capacity;
        size = size - 1;

        return toReturn;
    }
}
