package shree.exp.stacks;

import shree.exp.Utils;

/**
 * Created by shreedharkempanayakanahallichampakaram on 10/25/17.
 */
public class BasicStack {

    int top;
    final int MAX = 1000;
    final int[] arr;

    public BasicStack() {
        this.top = -1;
        this.arr = new int[MAX];

        for (int i = 0; i < arr.length ; i++) {
            arr[i] = -2;
        }
    }

    public void push(int i) {
        if(top >= MAX) {
            throw new IndexOutOfBoundsException();
        }

        arr[++top] = i;
    }

    public int pop() {
        if(top < 0) {
            return -1;
        }

        return arr[top--];
    }

    public int peek() {
        if(top < 0) {
            return -1;
        }

        return arr[top];
    }

    public int size() {
        return top+1;
    }

    public void print() {
        Utils.printArray(arr);
    }

    public static void main(String[] args) {
        BasicStack stack = new BasicStack();
        int[] input = {3,4,5,8,9,89};

        for (int i = 0; i < input.length; i++) {
            stack.push(input[i]);
        }

        stack.print();

        stack.pop();
        stack.pop();
        stack.push(111);
        stack.push(111);

        stack.print();
    }
}
