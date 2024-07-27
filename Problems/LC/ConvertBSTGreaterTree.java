class ConvertBSTGreaterTree {
    List<Integer> vals = new ArrayList<>();
    HashMap<Integer, Integer> greaterVals = new HashMap<>();

    void dfs(TreeNode curr) {
        if (curr == null) return;
        dfs(curr.left);
        vals.add(curr.val);
        dfs(curr.right);
    }

    void replace(TreeNode curr) {
        if (curr == null) return;
        curr.val = greaterVals.get(curr.val);
        replace(curr.left);
        replace(curr.right);
    }

    public TreeNode convertBST(TreeNode root) {
        dfs(root);

        int[] pSums = new int[vals.size() + 1];
        for (int i = 1; i < pSums.length; i++) {
            pSums[i] = pSums[i - 1] + vals.get(i - 1);
        }

        for (int i = 0; i < vals.size(); i++) {
            greaterVals.put(vals.get(i), pSums[pSums.length - 1] - pSums[i]);
        }

        replace(root);
        return root;
    }
}
