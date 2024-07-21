class FindBottomLeftTreeValue {
    int findDepth(TreeNode curr) {
        if (curr == null) return 0;
        int leftDepth = findDepth(curr.left);
        int rightDepth = findDepth(curr.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
    
    int bfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int maxDepth = findDepth(root);
        int currDepth = 1;
        while (!q.isEmpty()) {
            int levelLen = q.size();
            for (int i = 0; i < levelLen; i++) {
                TreeNode tmp = q.poll();
                if (currDepth == maxDepth) return tmp.val;

                if (tmp.left != null) q.add(tmp.left);
                if (tmp.right != null) q.add(tmp.right);
            }
            currDepth++;
        }

        return 0;
    }
    
    public int findBottomLeftValue(TreeNode root) {
        return bfs(root);
    }
}
