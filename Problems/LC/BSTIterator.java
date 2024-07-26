class BSTIterator {
    List<Integer> elements;
    int ptr;

    void dfs(TreeNode curr) {
        if (curr == null) return;
        dfs(curr.left);
        elements.add(curr.val);
        dfs(curr.right);
    }

    public BSTIterator(TreeNode root) {
        elements = new ArrayList<>();
        dfs(root);
        ptr = 0;
    }
    
    public int next() {
        int res = elements.get(ptr);
        ptr++;
        return res;
    }
    
    public boolean hasNext() {
        if (ptr < elements.size()) return true;
        return false;
    }
}
