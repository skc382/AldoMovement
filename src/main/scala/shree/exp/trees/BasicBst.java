package shree.exp.trees;


import shree.exp.stacks.BasicQ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BasicBst {

    private Node root = null;
    public BasicBst() {
    }

    public void add(int n) {
        if(root == null) {
            root = new Node(n);
            return;
        }
        addVal(root, n);
    }

    public Node addVal(Node node, int val) {

        if(node == null) {
            return new Node(val);
        }

        if(node.val >= val) {
            node.left = addVal(node.left, val);
        } else {
            node.right = addVal(node.right, val);
        }

        return node;
    }

    public void printPreorder() {

        System.out.println("Pre-Order: ");
        preOrderTraversal(root);
        System.out.println();
    }

    public void printInorder() {

        System.out.println("In-Order: ");
        inOrderTraversal(root);
        System.out.println();
    }

    public void printPostorder() {

        System.out.println("Post-Order: ");
        postOrderTraversal(root);
        System.out.println();
    }

    public void printLevelorder() {

        System.out.println("Level-Order: ");
        levelOrderTraversal(root);
        System.out.println();
    }

    private void preOrderTraversal(Node node) {
        if(node == null) {
            return;
        }

        System.out.print(node.val+", ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    private void inOrderTraversal(Node node) {
        if(node == null) {
            return;
        }

        inOrderTraversal(node.left);
        System.out.print(node.val+", ");
        inOrderTraversal(node.right);
    }

    private void inOrderTraversalNonRecursive(Node node) {
        Stack<Node> stack = new Stack<>();

        Node curr = node;
        stack.push(node);

        while(!stack.isEmpty()) {

        }
    }

    private void postOrderTraversal(Node node) {
        if(node == null) {
            return;
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.val+", ");
    }

    private void levelOrderTraversal(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while(q.peek() != null) {
            Node curr = q.remove();
            System.out.print(curr.val+", ");
            q.add(curr.left);
            q.add(curr.right);
        }
    }

    public void delete(int val) {
        root = deleteNode(root, val);
    }

    private Node deleteNode(Node root, int key) {

        if(root == null) {
            return null;
        }

        if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if(root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {

//            if(root.left == null && root.right == null) {
//                return null;
//            }

            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }

            // Has both children so find the inorder successor
            root.val = inOrderSuccessor(root);

            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }

    private int inOrderSuccessor(Node root) {
        int minv = root.val;
        while(root.left != null) {
            root = root.left;
            minv = root.val;
        }

        return minv;
    }

    class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        BasicBst bst = new BasicBst();
        int[] input = {50, 30, 20, 40, 70, 60, 80};

        for (int i = 0; i < input.length; i++) {
            bst.add(input[i]);
        }
//
//        bst.printPreorder();
//        bst.printInorder();
//        bst.printPostorder();
//        bst.printLevelorder();

        bst.printInorder();
        bst.delete(40);
        bst.printInorder();

        bst.printInorder();
        bst.delete(30);
        bst.printInorder();



    }
}
