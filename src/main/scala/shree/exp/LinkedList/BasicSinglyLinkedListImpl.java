package shree.exp.LinkedList;

/**
 * Created by shreedharkempanayakanahallichampakaram on 10/23/17.
 */
public class BasicSinglyLinkedListImpl {

    public static void main(String[] args) {
        int[] values = {3,5,6,9};

        SinglyList lst = new SinglyList();
        for (int i = 0; i < values.length ; i++) {
            lst.insertAtEnd(values[i]);
        }

//        lst.delete(9);
//        lst.insertAtPosition(9, 3);
        System.out.println(lst.search(3));
        System.out.println(lst.searchRecursive(50));
        System.out.println(lst.size());
    }

    public static class SinglyList {
        private Node head = null;

        public Node getHead() {
            return head;
        }

        public Node insertAtHead(int item) {
            Node node = new Node(item);

            Node temp = head;
            head = node;
            head.next = temp;

            return head;
        }

        public Node insertAtEnd(int item) {
            Node node = new Node(item);

            Node curr = head;

            if(curr == null) {
                head = node;
                return node;
            }

            while(curr.next != null) {
                curr = curr.next;
            }

            curr.next = node;

            return head;
        }

        public Node insertAtPosition(int item, int position) {
            Node node = new Node(item);

            int count = 1;

            Node curr = head;
            while(curr != null && count < position) {
                curr = curr.next;
                count++;
            }

            if(curr == null || count > position) {
                throw new IndexOutOfBoundsException();
            }

            Node temp = curr.next;
            curr.next = node;
            node.next = temp;

            return head;
        }

        public int search(int value) {
            if(head == null) {
                throw new RuntimeException("Damar");
            }

            Node curr = head;
            int count = 1;
            while(curr != null && curr.data != value) {
                curr = curr.next;
                count++;
            }

            if(curr == null) {
                return -1;
            }
            return count;
        }

        public int searchRecursive(int value) {
            if(head == null) {
                return -1;
            }

            return recurse(head, value, 1);
        }

        private int recurse(Node node, int value, int position) {
            if(node == null) {
                return - 1;
            }

            if(node.data == value) {
                return position;
            }

            return recurse(node.next, value, position + 1);
        }

        public int size() {
            if(head == null) {
                return -1;
            }

            Node curr = head;
            int count = 1;
            while(curr != null) {
                curr = curr.next;
                count ++;
            }

            return count - 1;
        }

        public void delete(int value) {
            if(head == null) {
                throw new RuntimeException("Damar");
            }

            Node prev = head;
            Node curr = prev.next;

            while(curr != null && curr.data != value) {
                prev = curr;
                curr = curr.next;
            }

            if(curr == null) {
                throw new RuntimeException("Item not found");
            }

            prev.next = curr.next;
            curr.next = null;

        }

    }

    public static class Node {
        public int data;
        public Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
