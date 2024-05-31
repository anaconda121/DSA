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
class InsertIntoBinaryTree {

    TreeNode insert(TreeNode curr, int val) {
        if (curr == null) { 
            curr = new TreeNode(val); 
            return curr; 
        }
        
        if (curr.val > val) { curr.left = insert(curr.left, val); } 
        else { curr.right = insert(curr.right, val); }
        return curr;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        root = insert(root, val);
        return root;
    }

}
