class ValidateBinaryTreeNodes {
    HashMap<Integer, Integer> indegreeCnt = new HashMap<>();
    HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
    boolean[] visited;
    boolean isCycle = false;

    void dfs(int node) {
        if (visited[node]) {
            isCycle = true;
            return;
        }
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            dfs(neighbor);
        }
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
            indegreeCnt.put(i, 0);
        }

        for (int i = 0; i < leftChild.length; i++) {
            if (leftChild[i] != -1) adj.get(i).add(leftChild[i]);
            if (rightChild[i] != -1) adj.get(i).add(rightChild[i]);
        }

        for (Map.Entry<Integer, ArrayList<Integer>> e : adj.entrySet()) {
            for (int node : e.getValue()) {
                indegreeCnt.put(node, indegreeCnt.get(node) + 1);
            }
        }

        int root = -1;
        boolean notValid = false;
        for (Map.Entry<Integer, Integer> e: indegreeCnt.entrySet()) {
            if (e.getValue() >= 2) return false;
            if (e.getValue() == 0 && root != -1) return false;
            else if (e.getValue() == 0) root = e.getKey();
        }
        if (root == -1) return false;
        
        dfs(root);
        
        if (isCycle) return false;
        for (boolean v : visited) if (!v) return false;
        return true;
    }
}
