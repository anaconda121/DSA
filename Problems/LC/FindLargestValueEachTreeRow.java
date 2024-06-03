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
class FindLargestValueEachTreeRow {
    HashMap<Integer, Integer> depth = new HashMap<>();

    void dfs(TreeNode curr, int d) {
        if (curr == null) return;
        int currMax = depth.getOrDefault(d, Integer.MIN_VALUE);
        depth.put(d, Math.max(currMax, curr.val));
        dfs(curr.left, d + 1);
        dfs(curr.right, d + 1);
    }

    public List<Integer> largestValues(TreeNode root) {
        dfs(root, 0);
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : depth.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}
