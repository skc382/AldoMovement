package shree.exp.LinkedList;

import java.util.Stack;

/**
 * Created by schampakaram on 1/16/18.
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        Node root = new Node('R', null);
        root.next = new Node('A', null);
        root.next.next = new Node('D', null);
        root.next.next.next = new Node('A', null);
        root.next.next.next.next = new Node('R', null);

        System.out.println(palindrome(root));

    }

    private static boolean palindrome(Node node) {
        // MALAYALAM
        Stack<Node> stack = new Stack<>();

        Node curr = node;
        while(curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        curr = node;

        while(curr != null) {
            if(stack.isEmpty()) {
                return false;
            }

            Node blah = stack.pop();
            if(curr.val != blah.val) {
                return false;
            }

            curr = curr.next;
        }

        return true;
    }
}
