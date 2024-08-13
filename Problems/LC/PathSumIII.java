class PathSumIII {
    long tot = 0;
    
    private void checkNewPaths(List<Integer> path, int target) {
        long sum = 0;
        for (int i = 0; i < path.size(); i++) sum += path.get(i);
        
        long currSubtract = 0;
        for (int i = 0; i < path.size(); i++) {
            if (sum - currSubtract == target) tot++;
            currSubtract += path.get(i);
        }
    }

    private void collectPaths(TreeNode node, int target, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (node == null) { return; }
        
        currentPath.add(node.val);
        checkNewPaths(currentPath, target);

        collectPaths(node.left, target, new ArrayList<>(currentPath), allPaths);
        collectPaths(node.right, target, new ArrayList<>(currentPath), allPaths);
    }

    public int pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        collectPaths(root, targetSum, currentPath, allPaths);        
        return (int) tot;
    }
}
