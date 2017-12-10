package shree.exp.LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shreedharkempanayakanahallichampakaram on 12/6/17.
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        Node head = new Node(arr[0], null);
        Node curr = head;
        for (int i = 1; i < arr.length ; i++) {
            curr.next = new Node(arr[i], null);
            curr=curr.next;
        }

        Node rev = reverse(head);

        while(rev != null) {
            System.out.println(rev.val);
            rev = rev.next;
        }
    }

    private static Node reverse(Node head) {

        Node curr = head;
        Node prev = null;
        while(curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

//    private static void reverseRecursive(Node curr, Node next, Node head) {
//
//        if(curr.next == null) {
//            head = curr;
//            curr.next = next;
//            return;
//        }
//
//
//    }

    static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

}


