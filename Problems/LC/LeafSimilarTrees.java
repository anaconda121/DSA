class LeafSimilarTrees {
    ArrayList<Integer> r1Seq = new ArrayList<>();
    ArrayList<Integer> r2Seq = new ArrayList<>();
    
    void dfs(TreeNode curr, boolean r1) {
        if (curr == null) return;
        
        if (curr.left == null && curr.right == null) {
            if (r1) r1Seq.add(curr.val);
            else r2Seq.add(curr.val);
        }
        
        dfs(curr.left, r1);
        dfs(curr.right, r1);
    }
    
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs(root1, true);
        dfs(root2, false);
      
        if (r1Seq.size() != r2Seq.size()) return false;
        for (int i = 0; i < r1Seq.size(); i++) {
            if ((int) r1Seq.get(i) != (int) r2Seq.get(i)) { return false; }
        }
        return true;
    }
}
