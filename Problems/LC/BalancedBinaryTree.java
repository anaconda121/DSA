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
class Solution {

    boolean ans = true;

    int dfs(TreeNode curr, int depth) {
        if (curr == null) return depth;
        int leftDepth = dfs(curr.left, depth + 1);
        int rightDepth = dfs(curr.right, depth + 1);
        if (Math.abs(leftDepth - rightDepth) > 1) ans = false;
        return Math.max(leftDepth, rightDepth);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        dfs(root, 1);
        return ans;
    }
}
