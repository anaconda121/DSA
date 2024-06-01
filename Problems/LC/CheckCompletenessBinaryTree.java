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
class CheckCompletenessBinaryTree {

    public static HashMap<Integer, List<Integer>> createDepthMap(TreeNode root) {
        if (root == null) {
            return new HashMap<>();
        }

        HashMap<Integer, List<Integer>> depthMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        queue.offer(root);
        depthQueue.offer(1);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            int currentDepth = depthQueue.poll();

            depthMap.computeIfAbsent(currentDepth, k -> new ArrayList<>()).add(currentNode.val);

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
                depthQueue.offer(currentDepth + 1);
            } else {
                if (currentNode.val > 0) {
                    queue.offer(new TreeNode(-1, null, null)); 
                    depthQueue.offer(currentDepth + 1);
                }
            }

            if (currentNode.right != null) {
                queue.offer(currentNode.right);
                depthQueue.offer(currentDepth + 1);
            } else {
                if (currentNode.val > 0) {
                    queue.offer(new TreeNode(-1, null, null)); 
                    depthQueue.offer(currentDepth + 1);
                }
            }

            
        }

        return depthMap;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public boolean isCompleteTree(TreeNode root) {
        HashMap<Integer, List<Integer>> depthMap = createDepthMap(root);
        int maxDepth = maxDepth(root);

        for (int i = 1; i <= maxDepth; i++) {
            // if (depthMap.get(i).get(0) != -1) {
                boolean nullReached = false;
                for (Integer j : depthMap.get(i)) {
                    if (j == -1) { 
                        if (i != maxDepth) return false;
                        nullReached = true; 
                    }
                    if (nullReached && j > 0) return false;
                }
            // }
        }

        return true;
    }
}
