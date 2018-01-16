package shree.exp.LinkedList;

import static shree.exp.LinkedList.BasicSinglyLinkedListImpl.SinglyList;

public class Swap2Elements {

    public static void main(String[] args) {

        int[] values = {3,5,6,9,10,20};

        SinglyList lst = new SinglyList();
        for (int i = 0; i < values.length ; i++) {
            lst.insertAtEnd(values[i]);
        }

        lst.print();
        lst.swap(6, 10);

        lst.print();
    }

}
