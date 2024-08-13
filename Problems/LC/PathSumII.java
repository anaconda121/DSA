class PathSumII {
    private void collectPaths(TreeNode node, int currSum, int target, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (node == null) {
            return;
        }

        currSum += node.val;
        currentPath.add(node.val);

        if (node.left == null && node.right == null && currSum  == target) {
            allPaths.add(new ArrayList<>(currentPath));
            return;
        }

        collectPaths(node.left, currSum, target, new ArrayList<>(currentPath), allPaths);
        collectPaths(node.right, currSum, target, new ArrayList<>(currentPath), allPaths);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        collectPaths(root, 0, targetSum, currentPath, allPaths);
        return allPaths;
    }
}
