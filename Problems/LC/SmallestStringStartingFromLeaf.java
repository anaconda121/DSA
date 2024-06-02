/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class SmallestStringStartingFromLeaf {
    
    void generatePaths(TreeNode node, String currentPath, List<String> paths) {
        if (node == null) { return; }
        currentPath = (char) ('a' + node.val) + currentPath;
        if (node.left == null && node.right == null) {
            paths.add(currentPath);
        } else {
            generatePaths(node.left, currentPath, paths);
            generatePaths(node.right, currentPath, paths);
        }
    }
    
    public String smallestFromLeaf(TreeNode root) {
        List<String> paths = new ArrayList<>();
        generatePaths(root, "", paths);
        Collections.sort(paths);
        return paths.get(0);
    }
  
}
