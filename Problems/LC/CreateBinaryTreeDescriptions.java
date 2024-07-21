class CreateBinaryTreeDescriptions {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> m = new HashMap<>();
        HashSet<Integer> hasParent = new HashSet<>();
        HashSet<Integer> nodes = new HashSet<>();

        for (int[] d : descriptions) {
            int p = d[0];
            int c = d[1];
            int lR = d[2];

            nodes.add(c);
            nodes.add(p);
            hasParent.add(c);
            
            TreeNode parent = m.getOrDefault(p, new TreeNode(p));
            TreeNode child = m.getOrDefault(c, new TreeNode(c));
            if (lR == 1) { parent.left = child; } 
            else { parent.right = child; }
            m.put(c, child);
            m.put(p, parent);
        }

        int root = -1;
        for (int i : nodes) {
            if (!hasParent.contains(i)) root = i;
        }
        
        return m.get(root);
    }   
}
