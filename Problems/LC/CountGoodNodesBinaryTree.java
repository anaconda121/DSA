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
class CountGoodNodesBinaryTree {
    
    int ans = 1; // root always counts

    void dfs(TreeNode curr, int maxVal) {
        if (curr == null) return;

        maxVal = Math.max(maxVal, curr.val);
        if (maxVal <= curr.val)  { ans++; }

        dfs(curr.left, maxVal);
        dfs(curr.right, maxVal); 
    } 

    public int goodNodes(TreeNode root) {
        dfs(root.left, root.val);
        dfs(root.right, root.val);
        return ans;
    }
}
