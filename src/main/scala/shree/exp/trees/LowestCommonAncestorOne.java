package shree.exp.trees;

/**
 * Created by shreedharkempanayakanahallichampakaram on 10/26/17.
 */
import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class LowestCommonAncestorOne {
    public static void main(String[] args) {

        // 12, 23, 4, 54, 65, 76, 80

        Node root = new Node(12);

        root.left = new Node(23);
        root.right = new Node(4);
        root.left.left = new Node(54);
        root.left.right = new Node(65);
        root.right.left = new Node(76);
        root.right.right = new Node(80);

        LCA l = new LCA();

        l.findLCA(root, 54, 80);

        LCATWO l2 = new LCATWO();

        System.out.println("L2 LCA: "+ l2.findLCA(root, 54, 80));

    }

    static class LCA {


        private void findLCA(Node root, int n1, int n2) {

            List<Integer> path1 = new ArrayList<Integer>();
            List<Integer> path2 = new ArrayList<Integer>();

            boolean b1 = findPath(root, n1, path1);
            boolean b2 = findPath(root, n2, path2);

            if(!b1 || !b2) {
                return;
            }

            for(int i = 0; i < path1.size() && i < path2.size(); i++) {
                if(!path1.get(i).equals(path2.get(i))) {
                    System.out.println(path1.get(i-1));
                    return;
                }
            }

        }


        public boolean findPath(Node root, int n, List<Integer> paths) {

            if(root == null) {
                return false;
            }

            paths.add(root.data);

            if(root.data == n) {
                return true;
            }

            if(findPath(root.left, n, paths))
            {
                return true;
            } else if(findPath(root.right, n, paths)) {
                return true;
            }

            paths.remove(paths.size() - 1);

            return false;

        }

    }

    static class LCATWO {

        public int findLCA(Node root, int n1, int n2) {
            return recurse(root, n1, n2);
        }

        private Integer recurse(Node node, int n1, int n2) {

            if(node == null) {
                return null;
            }

            if(node.data == n1 || node.data == n2) {
                return node.data;
            }

            Integer leftTreeVal = recurse(node.left, n1, n2);
            Integer rightTreeVal = recurse(node.right, n1, n2);

            if(leftTreeVal == null && rightTreeVal != null) {
                return leftTreeVal;
            } else if(leftTreeVal != null && rightTreeVal == null) {
                return rightTreeVal;
            }

            return node.data;
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

    }
}
