package shree.exp.stacks;


public class QueuesUsingStacks {

    BasicStack enqueueStack = new BasicStack();
    BasicStack dequeueStack = new BasicStack();

    public void enqueue(int item) {
        enqueueStack.push(item);
    }

    public int dequeue() {
        if(dequeueStack.peek() == -1) {
            emptyOneStackIntoTwo(enqueueStack, dequeueStack);
        }

       return dequeueStack.pop();
    }

    public int size() {
        return enqueueStack.size() + dequeueStack.size();
    }

    private void emptyOneStackIntoTwo(BasicStack s1, BasicStack s2) {

        while(s1.peek() != -1) {
            int item = s1.pop();
            s2.push(item);
        }
    }

    public static void main(String[] args) {
        QueuesUsingStacks q = new QueuesUsingStacks();

        int[] input = {3,4,5,8,9,89};

        for (int i = 0; i < input.length; i++) {
            q.enqueue(input[i]);
        }

        for (int i = 0; i < 10 ; i++) {
            System.out.println(q.dequeue());
        }

        int[] input2 = {33,43,53,83,93,893};

        for (int i = 0; i < input2.length; i++) {
            q.enqueue(input2[i]);
        }

        for (int i = 0; i < 10 ; i++) {
            System.out.println(q.dequeue());
        }

    }
}
