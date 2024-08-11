class FindClosestNodeGivenTwoNodes {
    private void bfs(int s, int t, int[] edges, HashMap<Integer, Integer> reachable) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[edges.length];
        q.add(new int[]{s, 0});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (visited[curr[0]]) continue;
            visited[curr[0]] = true;
            reachable.put(curr[0], curr[1]);
            if (curr[0] == t) { return; }
            if (edges[curr[0]] != -1) {
                q.add(new int[]{edges[curr[0]], curr[1] + 1});
            }
        }
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        HashMap<Integer, Integer> oneTwoPath = new HashMap<>();
        HashMap<Integer, Integer> twoOnePath = new HashMap<>();
        bfs(node1, node2, edges, oneTwoPath);
        bfs(node2, node1, edges, twoOnePath);

        int res = -1;
        int maxCloseDist = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> e : oneTwoPath.entrySet()) {
            if (twoOnePath.containsKey(e.getKey())) {
                int maxDist = Math.max(oneTwoPath.get(e.getKey()), twoOnePath.get(e.getKey()));
                if (maxDist == maxCloseDist) {
                    res = Math.min(res, e.getKey());
                } else if (maxDist < maxCloseDist) {
                    res = e.getKey();
                    maxCloseDist = maxDist;
                }
            }
        }
        return res;
    }
}
