package shree.exp.LinkedList;

import shree.exp.LinkedList.Node;

public class ReverseLinkedList {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        Node head = new Node(arr[0], null);
        Node curr = head;
        for (int i = 1; i < arr.length ; i++) {
            curr.next = new Node(arr[i], null);
            curr=curr.next;
        }

//        Node rev = reverse(head);
//
//        while(rev != null) {
//            System.out.println(rev.val);
//            rev = rev.next;
//        }

        Node node = rev(head);
        ;
        while(node != null) {
            System.out.println(node.val);
            node = node.next;
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

    /**
     * -- YET TO BE DONE !!!
     * @param node
     * @return
     */
    private static Node reverseRecursive(Node node) {

        Node first, rest;

        if(node == null)
            return node;

        first = node;
        rest = first.next;

        if(rest.next == null) {
            return node;
        }

        reverseRecursive(rest);
        rest.next = first;
        first.next = null;


        return rest;
    }

    private static Node rev(Node head) {

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


}


