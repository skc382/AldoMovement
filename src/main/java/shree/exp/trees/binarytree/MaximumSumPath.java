package shree.exp.trees.binarytree;

/**
 * Created by shreedharkempanayakanahallichampakaram on 12/17/17.
 */
public class MaximumSumPath {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);

        MaxVal maxVal = new MaxVal(Integer.MIN_VALUE);
        maxSum(root, maxVal);
        System.out.println("MaxVal: "+ maxVal.val);
    }

    private static int maxSum(Node node, MaxVal maxVal) {

        if(node == null) {
            return 0;
        }

        int l = maxSum(node.left, maxVal);
        int r = maxSum(node.right, maxVal);
        int nVal = node.data;

        int sum_single = Math.max(Math.max(l,r) + nVal, nVal);

        maxVal.val = Math.max((nVal + l + r), sum_single);

        return sum_single;
    }

    static class MaxVal {
        int val;

        public MaxVal(int val) {
            this.val = val;
        }
    }
}
