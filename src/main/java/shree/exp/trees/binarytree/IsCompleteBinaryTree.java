package shree.exp.trees.binarytree;

import shree.exp.trees.BST.BasicBst;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shreedharkempanayakanahallichampakaram on 12/15/17.
 */
public class IsCompleteBinaryTree {

    public static void main(String[] args) {
/* Let us construct the following Binary Tree which
          is not a complete Binary Tree
                1
              /   \
             2     3
            / \     \
           4   5     6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.right.left = new Node(6);

        if(isCompleteBinaryTree(root))
            System.out.println("Complete Binary Tree");
        else
            System.out.println("NOT Complete Binary Tree");
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
