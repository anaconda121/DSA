class ValidateBinarySearchTree {
    int prev = -1;
    int vis = 0;
    boolean res = true;

    void dfs(TreeNode curr) {
        if (curr == null) return;
        dfs(curr.left);
        if (vis > 0 && curr.val <= prev) {
            res = false;
            return;
        }
        prev = curr.val;
        vis++;
        dfs(curr.right);
    }

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return res;
    }
}
