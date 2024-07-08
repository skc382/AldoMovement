package shree.exp.trees.binarytree;

import java.util.*;

public class BasicBinaryTree {

    private Node root = null;

    public BasicBinaryTree(int[] arr) {

        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            if (this.root == null) {
                this.root = new Node(arr[i]);
            } else {
                Node current = root;
                Node prev = null;
                int randomValue = 0;

                while (current != null) {
                    if (((randomValue = random.nextInt()) % 2) == 0) {
                        prev = current;
                        current = current.left;
                    } else {
                        prev = current;
                        current = current.right;
                    }
                }

                if (prev != null)
                    if ((randomValue % 2) == 0) {
                        prev.left = new Node(arr[i]);
                    } else {
                        prev.right = new Node(arr[i]);
                    }
            }
        }
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
        if (node == null) {
            return;
        }

        System.out.print(node.data + ", ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    private void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);
        System.out.print(node.data + ", ");
        inOrderTraversal(node.right);
    }

    private void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + ", ");
    }

    private void levelOrderTraversal(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        int i = 0;
        while (q.size() > 0) {
            List<Node> list = new ArrayList<>();

            System.out.print("At Level-" + i + ": ");
            for (Node qNode : q) {
                if(qNode != null) {
                    System.out.print(qNode.data + ", ");
                    list.add(qNode);
                }
            }

            q.clear();

            for (Node lNode : list) {
                q.add(lNode.left);
                q.add(lNode.right);
            }
            i++;
            System.out.println();

        }
    }




    public static void main(String[] args) {
        int[] arr = {12, 23, 54, 1, 3, 78, 34};
        BasicBinaryTree binaryTree = new BasicBinaryTree(arr);

        binaryTree.printLevelorder();
        binaryTree.printInorder();
        binaryTree.printPreorder();
        binaryTree.printPostorder();
    }

    class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
