class RangeSumBST {
    int res = 0;

    void dfs(TreeNode curr, int l, int h) {
        if (curr == null) return;
        if (curr.val >= l && curr.val <= h) res += curr.val;
        dfs(curr.left, l, h);
        dfs(curr.right, l, h);
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return res;
    }
}
