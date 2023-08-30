import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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

public class BinaryTreeLevelOfKey {
    public int findLevel(TreeNode root, int key) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.val == key) {
                    return level;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            level++;
        }

        return 0; // Key not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the elements of the binary tree in level order (separated by spaces, -1 for null): ");
        String[] elements = scanner.nextLine().split(" ");

        TreeNode root = buildTree(elements, 0);

        System.out.print("Enter the key to find its level: ");
        int key = scanner.nextInt();

        BinaryTreeLevelOfKey finder = new BinaryTreeLevelOfKey();
        int level = finder.findLevel(root, key);

        if (level != 0) {
            System.out.println("The level of key " + key + " is: " + level);
        } else {
            System.out.println("Key " + key + " not found in the tree.");
        }

        scanner.close();
    }

    private static TreeNode buildTree(String[] elements, int index) {
        if (index >= elements.length || elements[index].equals("-1")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(elements[index]));
        node.left = buildTree(elements, 2 * index + 1);
        node.right = buildTree(elements, 2 * index + 2);

        return node;
    }
}
