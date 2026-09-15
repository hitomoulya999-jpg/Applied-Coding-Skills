class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, List<int[]>> map = new TreeMap<>();

        Queue<Object[]> queue = new LinkedList<>();

        queue.offer(new Object[]{root, 0, 0});

        while (!queue.isEmpty()) {

            Object[] current = queue.poll();

            TreeNode node = (TreeNode) current[0];
            int row = (int) current[1];
            int col = (int) current[2];

            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(new int[]{row, node.val});

            if (node.left != null) {
                queue.offer(new Object[]{
                    node.left, row + 1, col - 1
                });
            }

            if (node.right != null) {
                queue.offer(new Object[]{
                    node.right, row + 1, col + 1
                });
            }
        }

        for (List<int[]> list : map.values()) {

            Collections.sort(list, (a, b) -> {

                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }

                return a[1] - b[1];
            });

            List<Integer> column = new ArrayList<>();

            for (int[] item : list) {
                column.add(item[1]);
            }

            result.add(column);
        }

        return result;
    }
}