class BalanceBinarySearchTree {
    List<Integer> nodes = new ArrayList<>();

    // in order traversal
    void dfs(TreeNode curr) {
        if (curr == null) return;
        dfs(curr.left);
        nodes.add(curr.val);
        dfs(curr.right);
    }
    
    void createTreeRight(TreeNode curr, int s, int e) {
        if (s == e) return;
        int m = s + (e - s) / 2;
        curr.right = new TreeNode(nodes.get(m));
        createTreeLeft(curr.right, s, m);
        createTreeRight(curr.right, m + 1, e);
    }

    void createTreeLeft(TreeNode curr, int s, int e) {
        if (s == e) return;
        int m = s + (e - s) / 2;
        curr.left = new TreeNode(nodes.get(m));
        createTreeLeft(curr.left, s, m);
        createTreeRight(curr.left, m + 1, e);
    }

    public TreeNode balanceBST(TreeNode root) {
        dfs(root);
        int l = 0;
        int r = nodes.size();
        int m = l + (r - l) / 2;
        TreeNode newRoot = new TreeNode(nodes.get(m));
        createTreeLeft(newRoot, 0, m);
        createTreeRight(newRoot, m + 1, nodes.size());
        return newRoot;
    }
}
