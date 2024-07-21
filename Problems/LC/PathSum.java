class PathSum {
    boolean found = false;

    void dfs(TreeNode curr, int val, int target) {
        if (curr == null) return;

        if (val + curr.val == target && curr.left == null & curr.right == null) {
            found = true;
            return;
        }

        dfs(curr.left, val + curr.val, target);
        dfs(curr.right, val + curr.val, target);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root, 0, targetSum);
        return found;
    }
}
