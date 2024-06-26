package blah.just.practice;

import com.sun.security.auth.UnixNumericUserPrincipal;

public class BLinkedList {
    public static void main(String[] args) {

        MyLinkedList l = new MyLinkedList(3,6,5,4);
        l.print();
        l.addToEnd(100);
        l.print();
        l.reverse();
        l.print();
    }

    static class MyLinkedList {

        private Node root;
        MyLinkedList(Integer... i) {
            root = new Node(i[0], null);

            Node prev = root;
            for (int j = 1; j < i.length; j++) {
                Node curr = new Node(i[j], null);
                prev.next  = curr;
                prev = curr;
            }
        }

        void addToEnd(int value) {
            Node curr = root;
            while(curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(value, null);
        }

        void addToFirst(int value) {
            Node neww = new Node(value, null);
            neww.next = root;
            root = neww;
        }

        void reverse() {
            Node prev = null;
            Node curr = root;

            while(curr != null) {
                Node temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            root = prev;
        }

        public void print() {
            Node curr = root;
            while(curr != null) {
                System.out.println(curr.value);
                curr = curr.next;
            }
            System.out.println();
        }

    }

    static class Node {

        int value;
        Node next;

        Node(int z, Node next) {
            this.next= next;
            this.value=z;
        }
    }
}
