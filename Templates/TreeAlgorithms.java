import java.util.LinkedList;
import java.util.Queue;

public class TreeAlgorithms {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    void BFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            System.out.println(tempNode.val);
            if (tempNode.left != null) { queue.add(tempNode.left); }
            if (tempNode.right != null) { queue.add(tempNode.right); }
        }
    }

}
