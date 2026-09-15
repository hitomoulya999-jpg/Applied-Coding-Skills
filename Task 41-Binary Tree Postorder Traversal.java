class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
         List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return result;
        }

        stack.push(root);

        while (!stack.isEmpty()) {

            root = stack.pop();
            result.add(root.val);

            if (root.left != null) {
                stack.push(root.left);
            }

            if (root.right != null) {
                stack.push(root.right);
            }
        }

        Collections.reverse(result);

        return result;
    }
}