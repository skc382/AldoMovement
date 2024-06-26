package shree.exp.trees.BST;


public class ConstructBST {

    public static void main(String[] args) {
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};

        Index index = new Index();
        index.index = 0;
        Node root = construct(pre, index, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE);

        inOrderTraversal(root);
    }

    private static void inOrderTraversal(Node node) {
        if(node == null) {
            return;
        }

        inOrderTraversal(node.left);
        System.out.print(node.data +", ");
        inOrderTraversal(node.right);
    }

    private static Node construct(int[] arr, Index currentIndex, int val, int min, int max) {


        if(currentIndex.index >= arr.length) {
            return null;
        }

        Node root = null;

        if(val > min && val < max) {
            root = new Node(val);
             currentIndex.index = currentIndex.index+1;

            if(currentIndex.index < arr.length) {

                root.left = construct(arr, currentIndex, arr[currentIndex.index], min, val);

                root.right = construct(arr, currentIndex, arr[currentIndex.index], val, max);
            }
        }

        return root;
    }

    static class Index {
        int index = 0;
    }
}
