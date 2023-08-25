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

public class BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        if (isBalanced(root)) {
            System.out.println("The binary tree is balanced.");
        } else {
            System.out.println("The binary tree is not balanced.");
        }
    }
}
