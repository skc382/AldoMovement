package shree.exp.LinkedList;

import static shree.exp.LinkedList.BasicSinglyLinkedListImpl.SinglyList;
import static shree.exp.LinkedList.BasicSinglyLinkedListImpl.Node;

public class Swap2Elements {

    public static void main(String[] args) {

        int[] values = {3,5,6,9,10,20};

        SinglyList lst = new SinglyList();
        for (int i = 0; i < values.length ; i++) {
            lst.insertAtEnd(values[i]);
        }

        swapElements(lst, 6, 10);

        System.out.println(lst);
    }

    public static int swapElements(SinglyList lst, int x, int y) {

        Node prevX=lst.getHead(), currX=lst.getHead(), prevY=lst.getHead(), currY=lst.getHead();

        int notFound = 2;
        while (true) {
            if(currX != null && currX.data == x) {
                notFound--;
            } else if(currX.data != x) {
                prevX = currX;
                currX = currX.next;
            }

            if(currY != null && currY.data == y) {
                notFound--;
            } if(currY.data != y) {
                prevY = currY;
                currY = currY.next;
            }

            if(notFound < 1) {
                break;
            }
        }

        if(currX == null || currY == null) {
            return -1;
        }

        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;

        return 0;
    }
}
