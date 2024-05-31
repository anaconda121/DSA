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
class ConstructStringFromBinaryTree {

    String dfs(TreeNode curr) {
        if (curr == null) return "";
        if (curr.left != null && curr.right != null)
            return curr.val + "(" + dfs(curr.left) + ")" + "(" + dfs(curr.right) + ")";
        else if (curr.left != null)
            return curr.val + "(" + dfs(curr.left) + ")";
        else if (curr.right != null)
            return curr.val + "()" + "(" + dfs(curr.right) + ")";
        return String.valueOf(curr.val);
    }

    public String tree2str(TreeNode root) {
        return dfs(root);
    }
}
