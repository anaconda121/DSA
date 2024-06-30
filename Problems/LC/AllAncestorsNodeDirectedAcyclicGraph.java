class AllAncestorsNodeDirectedAcyclicGraph {
    List<List<Integer>> adj = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    void dfs(int start, int current, boolean[] visited) {
        visited[current] = true;
        for (int next : adj.get(current)) {
            if (!visited[next]) {
                res.get(start).add(next);
                dfs(start, next, visited);
            }
        }
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            res.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            dfs(i, i, new boolean[n]);
        }

        for (List<Integer> list : res) {
            Collections.sort(list);
        }

        return res;
    }
}
