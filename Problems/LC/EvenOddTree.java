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
class EvenOddTree {

    boolean bfs(TreeNode root) {
        if (root == null) { return false; }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        Queue<Integer> depth = new LinkedList<>();
        depth.add(0);
        TreeNode prev = new TreeNode(0);
        int prevDepth = -1;
        
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            int currDepth = depth.poll();
            if (prevDepth != currDepth) { 
                if (currDepth % 2 == 0) prev = new TreeNode(0); 
                else prev = new TreeNode((int) Math.pow(10, 6) + 1);
            }

            if (currDepth % 2 == 0) {
                if (currentNode.val % 2 != 1 || currentNode.val <= prev.val && currentNode != prev) return false;
            } else {
                if (currentNode.val % 2 != 0 || currentNode.val >= prev.val && currentNode != prev) return false;
            }
            
            if (currentNode.left != null) { queue.add(currentNode.left); depth.add(currDepth + 1); }
            if (currentNode.right != null) { queue.add(currentNode.right); depth.add(currDepth + 1); }

            prev = currentNode;
            prevDepth = currDepth;
        }

        return true;
    }

    public boolean isEvenOddTree(TreeNode root) {
        return bfs(root);
    }
}
