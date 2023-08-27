class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class KthLargestInBST {
    private static int count = 0;
    private static int result = Integer.MIN_VALUE;

    public static int kthLargest(TreeNode root, int k) {
        count = 0;
        result = Integer.MIN_VALUE;
        reverseInorder(root, k);
        return result;
    }

    private static void reverseInorder(TreeNode node, int k) {
        if (node == null || count >= k) {
            return;
        }

        reverseInorder(node.right, k);
        count++;

        if (count == k) {
            result = node.val;
            return;
        }

        reverseInorder(node.left, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);

        int k = 3;
        int kthLargestValue = kthLargest(root, k);
        System.out.println("The " + k + "th largest element in the BST is: " + kthLargestValue);
    }
}
