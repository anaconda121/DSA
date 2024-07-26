class AddOneRowTree {
    void dfs(TreeNode curr, int currDepth, int val, int targetDepth) {
        if (curr == null) return;

        if (currDepth == targetDepth) {
            TreeNode prevL = curr.left;
            TreeNode prevR = curr.right;

            curr.left = new TreeNode(val);
            curr.left.left = prevL;

            curr.right = new TreeNode(val);
            curr.right.right = prevR;

            return;
        }

        dfs(curr.left, currDepth + 1, val, targetDepth);
        dfs(curr.right, currDepth + 1, val, targetDepth);
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        dfs(root, 1, val, depth - 1);
        return root;
    }
}
