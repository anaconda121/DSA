class VerticalOrderTraversalBinaryTree {
    class RCNode {
        int r; int c; int val;
        RCNode(int _r, int _c, int _v) {
            r = _r;
            c = _c;
            val = _v;
        }
    }

    public class RCNodeComparator implements Comparator<RCNode> {
        @Override
        public int compare(RCNode node1, RCNode node2) {
            if (node1.c == node2.c) {
                if (node1.r == node2.r) { return Integer.compare(node1.val, node2.val); }
                return Integer.compare(node1.r, node2.r);
            }
            return Integer.compare(node1.c, node2.c);
        }
    }

    TreeMap<Integer, PriorityQueue<RCNode>> heights = new TreeMap<>();

    void dfs(TreeNode curr, int currRow, int currCol) {
        if (curr == null) return;

        PriorityQueue<RCNode> pq = heights.getOrDefault(currCol, new PriorityQueue<RCNode>(new RCNodeComparator()));
        pq.add(new RCNode(currRow, currCol, curr.val));
        heights.put(currCol, pq);

        dfs(curr.left, currRow + 1, currCol - 1);
        dfs(curr.right, currRow + 1, currCol + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);

        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, PriorityQueue<RCNode>> e : heights.entrySet()) {
            PriorityQueue<RCNode> pq = e.getValue();
            List<Integer> c = new ArrayList<>();
            while (!pq.isEmpty()) {
                c.add(pq.poll().val);
            }
            res.add(c);
        }
        return res;
    }
}
