package shree.exp.trees.heaps;

import shree.exp.trees.binarytree.IsCompleteBinaryTree;

import java.util.LinkedList;
import java.util.Queue;


public class IsBinaryHeap {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(8);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(2);
        root.left.right.left = new Node(1);

        if(isCompleteBinaryTree(root) && isMaxHeap(root))
            System.out.println("Given binary tree is a Heap");
        else
            System.out.println("Given binary tree is not a Heap");
    }


    public static boolean isMaxHeap(Node root) {

        if(root.left == null && root.right == null) {
            return true;
        }

        if(root.left != null) {
            if(root.val > root.left.val) {
                return true;
            }
        } else {
            if((root.val > root.left.val) && (root.val > root.right.val)) {
                return isMaxHeap(root.left) && isMaxHeap(root.right);
            }
        }

        return false;
    }

    public static boolean isCompleteBinaryTree(Node root) {

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean leafNodeFound = false;

        while(q.size() > 0) {
            Node node = q.remove();
            System.out.println(node.val);
            if(leafNodeFound && (node.left != null || node.right != null)) {
                return false;
            }

            if(node.left == null && node.right == null) {
                leafNodeFound = true;
            } else if(node.left != null && node.right == null) {
                leafNodeFound = true;
            } else if(node.left == null && node.right != null) {
                return false;
            }

            if(node.left != null) {
                q.add(node.left);
            }

            if(node.right != null) {
                q.add(node.right);
            }
        }

        return true;
    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
}
