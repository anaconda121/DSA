class DeleteNodesReturnForest {
    List<TreeNode> initial = new ArrayList<>();
    List<TreeNode> res = new ArrayList<>();
    HashSet<TreeNode> visited = new HashSet<>();

    void dfs(TreeNode curr, boolean afterDelete) {
        if (curr == null) return;
        if (afterDelete && visited.contains(curr)) return;
        if (afterDelete) visited.add(curr);
        if (!afterDelete) initial.add(curr);
        dfs(curr.left, afterDelete);
        dfs(curr.right, afterDelete);
    }

    TreeNode dfsDelete(TreeNode curr, HashSet<Integer> del) {
        if (curr == null) return null;
        if (visited.contains(curr)) return null;
        
        curr.left = dfsDelete(curr.left, del);
        curr.right = dfsDelete(curr.right, del);
        if (del.contains(curr.val)) return null;
        
        return curr;
    }
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        dfs(root, false);
        
        HashSet<Integer> del = new HashSet<>();
        for (int i : to_delete) { del.add(i); }
        dfsDelete(root, del);

        visited = new HashSet<>();
        for (TreeNode t : initial) {
            if (!visited.contains(t) && !del.contains(t.val)) {
                res.add(t);
                dfs(t, true);
            }
        }

        return res;
    }
}
