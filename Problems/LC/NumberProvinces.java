class NumberProvinces {
    HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    
    void dfs(int curr) {
        if (visited.contains(curr)) return;
        visited.add(curr);
        for (int n : adj.get(curr)) {
            dfs(n);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        for (int i = 0; i < isConnected.length; i++) {
            int[] currConnections = isConnected[i];
            ArrayList<Integer> adjConnections = new ArrayList<>();
            for (int j = 0; j < currConnections.length; j++) {
                if (currConnections[j] == 1) adjConnections.add(j);
            }
            adj.put(i, adjConnections);
        }
        
        int res = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited.contains(i)) {
                res++; 
                dfs(i);
            }
        }
        return res;
    }
}
