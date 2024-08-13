class ReorderRoutesMakeAllPathsLeadCityZero {
    HashMap<Integer, ArrayList<Integer>> undirectedAdj = new HashMap<>();
    HashMap<Integer, HashSet<Integer>> directedAdj = new HashMap<>();

    int dfs(int node, HashSet<Integer> visited) {
        int numberFlips = 0;
        visited.add(node);
        HashSet<Integer> correspondingDirected = directedAdj.get(node);

        for (int n : undirectedAdj.get(node)) {
            if (!visited.contains(n)) {
                if (correspondingDirected.contains(n)) {
                    numberFlips++;
                }
                numberFlips += dfs(n, visited);
            }
        }
        return numberFlips;
    }

    public int minReorder(int n, int[][] connections) {
        for (int i = 0; i < n; i++) {
            undirectedAdj.put(i, new ArrayList<>());
            directedAdj.put(i, new HashSet<>());
        }

        for (int[] c : connections) {
            undirectedAdj.get(c[0]).add(c[1]);
            undirectedAdj.get(c[1]).add(c[0]);
            directedAdj.get(c[0]).add(c[1]);
        }

        return dfs(0, new HashSet<>());
    }
}
