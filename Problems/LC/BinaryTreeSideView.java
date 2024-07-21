class BinaryTreeSideView {
    List<Integer> res = new ArrayList<>();
    
    void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelLen = queue.size();
            int rightMost = -1;
            for (int i = 0; i < levelLen; i++) {
                TreeNode tempNode = queue.poll();
                rightMost = tempNode.val;
                if (tempNode.left != null) { queue.add(tempNode.left); }
                if (tempNode.right != null) { queue.add(tempNode.right); }
            }
            res.add(rightMost);
        }
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return res;

        bfs(root);
        return res;
    }
}
