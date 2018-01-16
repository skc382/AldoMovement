package shree.exp.LinkedList;

/**
 * Created by schampakaram on 1/16/18.
 */
public class RemoveLoopsLinkedList {

    public static int detectAndRemove(Node head) {

        Node slow = head, fast = head;


        while(slow != null && fast != null) {

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                removeLoop(slow, head);
                return 1;
            }

        }

        return 0;
    }


    public static void removeLoop(Node slow, Node head) {

        Node p1 = slow;
        Node p2 = slow;

        int count = 1;
        while(p1.next != p2) {
            p1 = p1.next;
            count++;
        }

        p1 = p2 = head;

        for (int i = 0; i < count ; i++) {
            p2 = p2.next;
        }

        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        while(p2.next != p1) {
            p2 = p2.next;
        }

        p2.next = null;

    }

    public static void print(Node node) {
        while(node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = new Node(1, null);
        head.next = new Node(2, null);
        head.next.next = new Node(3, null);
        head.next.next.next = new Node(4, null);
        head.next.next.next.next = head.next.next;

        detectAndRemove(head);
        print(head);

    }
}
