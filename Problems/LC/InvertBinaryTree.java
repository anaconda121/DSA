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
class InvertBinaryTree {

    // three cases
    // has 2 children
    // has 1 child
    // has 0 children

    void dfs(TreeNode curr) {
        if (curr == null) return;
        if (curr.left == null && curr.right == null) return;

        if (curr.left != null && curr.right != null) {
            TreeNode tmp = curr.left;
            curr.left = curr.right;
            curr.right = tmp;
        } else if (curr.right != null && curr.left == null) {
            curr.left = new TreeNode(curr.right.val, curr.right.left, curr.right.right);
            curr.right = null;
        } else if (curr.left != null && curr.right == null) {
            curr.right = new TreeNode(curr.left.val, curr.left.left, curr.left.right);
            curr.left = null;
        }

        dfs(curr.right);
        dfs(curr.left);
    }

    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }
}
