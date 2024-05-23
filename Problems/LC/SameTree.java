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
class SameTree {

    boolean dfs(TreeNode curr1, TreeNode curr2) {
        if (curr1 == null && curr2 == null) return true;
        if ((curr1 == null && curr2 != null) || (curr1 != null && curr2 == null)) return false;
        if (curr1.val != curr2.val) return false;

        return dfs(curr1.left, curr2.left) && dfs(curr1.right, curr2.right);
    } 

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }
}
