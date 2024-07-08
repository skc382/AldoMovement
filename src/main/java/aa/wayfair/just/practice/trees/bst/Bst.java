package aa.wayfair.just.practice.trees.bst;


import java.util.LinkedList;
import java.util.Queue;

public class Bst {

    public static void main(String[] args) {
        Bst b = new Bst();
//        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
//        for (int i : pre) {
//            b.add(i);
//        }
//        b.levelOrderTraversal();
//        b.inOrderTraversal();
//
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.left.right.right = new Node(8);
////        root.right.left = new Node(6);
//
//        if (b.isCompleteBinaryTree(root))
//            System.out.println("Complete Binary Tree");
//        else
//            System.out.println("NOT Complete Binary Tree");


        Node root = new Node(12);

        root.left = new Node(23);
        root.right = new Node(4);
        root.left.left = new Node(54);
        root.left.right = new Node(65);
        root.right.left = new Node(76);
        root.right.right = new Node(80);

        System.out.println(b.leastCommonAncestor(root, 76, 80));
    }

    private Node root = null;

    public Node add(int data) {
        if (this.root == null) {
            this.root = new Node(data);
            return root;
        }
        return innerAdd(this.root, data);
    }

    private Node innerAdd(Node curr, int data) {
        if (curr == null) {
            return new Node(data);
        }

        if (data <= curr.data) {
            curr.left = innerAdd(curr.left, data);
        } else {
            curr.right = innerAdd(curr.right, data);
        }
        return curr;
    }

    public void inOrderTraversal() {
        System.out.println("pre-order traversal");
        this.inOrderTraversalInner(this.root);
    }

    public void inOrderTraversalInner(Node curr) {
        if (curr == null) {
            return;
        }

        inOrderTraversalInner(curr.left);
        System.out.print(curr.data + " ");
        inOrderTraversalInner(curr.right);
    }

    public void levelOrderTraversal() {
        Queue<Node> q = new LinkedList<>();

        System.out.println("level order traversal");
        q.add(this.root);
        while (q.peek() != null) {
            Node curr = q.remove();
            System.out.print(curr.data + " ");
            q.add(curr.left);
            q.add(curr.right);
        }
        System.out.println();

    }

    public boolean isCompleteBinaryTree(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        boolean leftNodeFound = false;

        while (q.peek() != null) {
            Node curr = q.remove();

            System.out.println(curr.data);
            if (leftNodeFound && (curr.left != null || curr.right != null)) {
                return false;
            }

            if (curr.left == null && curr.right == null) {
                leftNodeFound = true;
            } else if (curr.left != null && curr.right == null) {
                leftNodeFound = true;
            } else if (curr.left == null && curr.right != null) {
                return false;
            }

            if (curr.left != null) {
                q.add(curr.left);
            }

            if (curr.right != null) {
                q.add(curr.right);
            }
        }
        return true;
    }

    private Integer leastCommonAncestor(Node node, int a, int b) {
        if (node == null) {
            return null;
        }

        if (node.data == a || node.data == b) {
            return node.data;
        }

        Integer leftTreeValue = leastCommonAncestor(node.left, a, b);
        Integer rightTreeValue = leastCommonAncestor(node.right, a, b);

        if (leftTreeValue != null && rightTreeValue != null) {
            return node.data;
        }

        return leftTreeValue != null ? leftTreeValue : rightTreeValue;
    }


}
