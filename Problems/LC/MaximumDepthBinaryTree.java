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
class MaximumDepthBinaryTree {

    int ans = 0;

    void dfs(TreeNode curr, int depth) {
        if (curr == null) return;
        if (curr.left == null && curr.right == null) {
            ans = Math.max(ans, depth);
            return;
        }

        dfs(curr.right, depth + 1);
        dfs(curr.left, depth + 1);
    }

    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return ans;
    }
}
