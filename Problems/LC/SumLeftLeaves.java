class SumLeftLeaves {
    int sum = 0;
    void dfs(TreeNode curr, boolean left) {
        if (curr == null) return;
        if (curr.left == null && curr.right == null && left) {
            sum += curr.val;
            return;
        }
        dfs(curr.left, true);
        dfs(curr.right, false);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        dfs(root.left, true);
        dfs(root.right, false);
        return sum;
    }
}
