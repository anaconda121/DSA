class CountNumberGoodNodes {
    HashMap<Integer, Integer> subChildren = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
    ArrayList<Integer> order = new ArrayList<>();
    
    void dfs(int curr) {
        visited.add(curr);
        order.add(curr);
        int cnt = 0;
        for (int n : adj.get(curr)) {
            if (!visited.contains(n)) {
            dfs(n);
            cnt += 1+subChildren.getOrDefault(n,0);
            }
        }
        subChildren.put(curr, cnt);
    }

    public int countGoodNodes(int[][] edges) {
        for (int i = 0; i <= edges.length; i++) {
            adj.put(i, new ArrayList<Integer>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        for (int i = 0; i <= edges.length; i++) {
            if (!visited.contains(i)) dfs(i);
        }

        int res = 0;
        visited = new HashSet<>();
        for (int i = 0; i < order.size(); i++) {
            ArrayList<Integer> curr = adj.get(order.get(i));
            int cnt = -1;
            boolean same = true;
            visited.add(order.get(i));
            for (int children : curr) {
                if (!visited.contains(children)) {
                    if (cnt == -1) cnt = subChildren.getOrDefault(children,0);
                    else {
                        if (subChildren.get(children) != cnt) {
                            same = false;
                            break;
                        }
                    }
                    visited.add(children);
                }
            }
            if (same) {
                res++;
            }
        }
        return res;
    }
}
