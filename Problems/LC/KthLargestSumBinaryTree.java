class KthLargestSumBinaryTree {
    PriorityQueue<Long> levelSums = new PriorityQueue<>(Collections.reverseOrder());

    void bfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int levelLen = q.size();
            long level = 0;
            for (int i = 0; i < levelLen; i++) {
                TreeNode tmp = q.poll();
                level += (long) tmp.val;
                if (tmp.left != null) q.add(tmp.left);
                if (tmp.right != null) q.add(tmp.right);
            }
            levelSums.add(level);
        }
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        bfs(root);
        if (levelSums.size() < k) return -1;

        int ptr = 0;
        while (ptr < k - 1) {
            levelSums.poll();
            ptr++;
        }
        return levelSums.poll();
    }
}
