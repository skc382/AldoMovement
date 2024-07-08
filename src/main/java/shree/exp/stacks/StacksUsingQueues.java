package shree.exp.stacks;

/**
 * Created by shreedharkempanayakanahallichampakaram on 10/25/17.
 */
public class StacksUsingQueues {

    BasicQ q1 = new BasicQ();
    BasicQ q2 = new BasicQ();

    public void push(int item) {
        q1.enqueue(item);
    }

    public int pop() {
        if(q1.isEmpty()) {
            return -1;
        }

        while(q1.getSize() > 1) {
            q2.enqueue(q1.dequeue());
        }

        int toReturn = q1.dequeue();

        BasicQ q = q1;
        q1 = q2;
        q2 = q;

        return toReturn;
    }

    private void print() {
        q1.print();
        q2.print();
        System.out.println();
    }

    public static void main(String[] args) {
        StacksUsingQueues stack = new StacksUsingQueues();
        int[] input = {3,4,5,8,9,89};

        for (int i = 0; i < input.length; i++) {
            stack.push(input[i]);
        }

        stack.print();

        System.out.println("Popped: "+stack.pop());
        System.out.println("Popped: "+stack.pop());
        stack.push(111);
        stack.push(111);

        stack.print();

        System.out.println("Popped: "+stack.pop());
        System.out.println("Popped: "+stack.pop());
        System.out.println("Popped: "+stack.pop());

        stack.print();
    }
}
