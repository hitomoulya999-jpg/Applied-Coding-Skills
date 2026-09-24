class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        val = value;
    }
}

class Solution {
    private int diameter;

    private int findHeight(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftHeight =
            findHeight(node.left);

        int rightHeight =
            findHeight(node.right);

        diameter = Math.max(
            diameter,
            leftHeight + rightHeight
        );

        return 1 + Math.max(
            leftHeight,
            rightHeight
        );
    }

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;

        findHeight(root);

        return diameter;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Solution solution = new Solution();

        System.out.println(
            solution.diameterOfBinaryTree(root)
        );
    }
}