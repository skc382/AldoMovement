package shree.exp.trees.BST;


import com.sun.source.tree.BinaryTree;

public class IsBstCheck {

    public static void main(String[] args) {
        BasicBst bst = new BasicBst();

        int[] input = {50, 30, 20, 40, 70, 60, 80};

        for (int i = 0; i < input.length; i++) {
            bst.add(input[i]);
        }

        boolean flag = isBst(bst.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE);

        if(flag) {
            System.out.println("Is a BST");
        } else {
            System.out.println("Not a BST!!! WTF");
        }
    }

    private static boolean isBst(Node node, int min, int max) {

        if(node == null) {
            return true;
        }

        if(node.data > max || node.data < min) {
            return false;
        }

        return isBst(node.left, min, node.data -1) &&
                isBst(node.right, node.data +1, max);
    }
}
