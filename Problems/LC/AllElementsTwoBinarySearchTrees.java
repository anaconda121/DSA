class AllElementsTwoBinarySearchTrees {
    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new ArrayList<>();

    void dfs(TreeNode curr, boolean isL1) {
        if (curr == null) return;
        dfs(curr.left, isL1);
        if (isL1) l1.add(curr.val);
        else l2.add(curr.val);
        dfs(curr.right, isL1);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        dfs(root1, true); dfs(root2, false);

        List<Integer> res = new ArrayList<>();
        int l1Ptr = 0; int l2Ptr = 0;
        while (l1Ptr < l1.size() && l2Ptr < l2.size()) {
            if (l1.get(l1Ptr) < l2.get(l2Ptr)) {
                res.add(l1.get(l1Ptr)); 
                l1Ptr++;
            } else {
                res.add(l2.get(l2Ptr));
                l2Ptr++;
            }
        }

        while (l1Ptr < l1.size()) {
            res.add(l1.get(l1Ptr));
            l1Ptr++;
        }

        while (l2Ptr < l2.size()) {
            res.add(l2.get(l2Ptr));
            l2Ptr++;
        }
        
        return res;
    }
}
