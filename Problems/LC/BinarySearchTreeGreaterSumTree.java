class BinarySearchTreeGreaterSumTree {
    int N = 105;
    ArrayList<Integer> vals = new ArrayList<>();
    ArrayList<Integer> prefixSums = new ArrayList<>();
    boolean[] visited = new boolean[N];

    void dfs(TreeNode curr) {
        if (curr == null) return;
        if (visited[curr.val]) return;
        visited[curr.val] = true;
        vals.add(curr.val);
        dfs(curr.left);
        dfs(curr.right);
    }

    void dfs2(TreeNode curr) {
        if (curr == null) return;
        if (visited[curr.val]) return;
        visited[curr.val] = true;
        int idx = Collections.binarySearch(vals, curr.val);
        curr.val = prefixSums.get(prefixSums.size() - 1) - prefixSums.get(idx) + curr.val;
        dfs2(curr.left);
        dfs2(curr.right);
    }

    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        Collections.sort(vals);

        int sum = 0;
        for (int num : vals) { sum += num; prefixSums.add(sum); }

        visited = new boolean[N];
        dfs2(root);

        return root;
    }
}
