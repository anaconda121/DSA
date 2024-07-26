class FlipEquivalentBinaryTrees {
    boolean res = true;

    void dfs(TreeNode r1, TreeNode r2) {
        if (r1 == null || r2 == null) return;

        Integer r1Left = (r1.left == null) ? null : r1.left.val;
        Integer r2Left = (r2.left == null) ? null : r2.left.val;
        Integer r1Right = (r1.right == null) ? null : r1.right.val;
        Integer r2Right = (r2.right == null) ? null : r2.right.val;

        if ((r1Left == r2Right && r1Right == r2Left) && r1.val == r2.val) {
            TreeNode tmp = r1.left;
            r1.left = r1.right;
            r1.right = tmp;
        } else if (r1.val != r2.val || r1Left != r2Left || r1Right != r2Right) res = false;

        dfs(r1.left, r2.left);
        dfs(r1.right, r2.right);
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null || root2 == null && root1 != null) return false;
        dfs(root1, root2);
        return res;
    }
}
