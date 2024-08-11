class CourseScheduleII {
    boolean[] visited;
    boolean[] path;

    boolean isCycle = false;
    HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
    ArrayList<Integer> res = new ArrayList<>();

    void dfs(int n) {
        if (visited[n] || path[n]) {
            if (path[n]) isCycle = true;
            return;
        }

        visited[n] = true;
        path[n] = true;
        for (int neighbor : adj.get(n)) { dfs(neighbor); }
        path[n] = false;
        res.add(n);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        path = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) { adj.put(i, new ArrayList<>()); }

        for (int[] p : prerequisites) {
            ArrayList<Integer> curr = adj.get(p[1]);
            curr.add(p[0]);
            adj.put(p[1], curr);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                dfs(i);
                if (isCycle) return new int[]{};
            }
        }
        
        int[] ans = new int[numCourses];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(res.size() - 1 - i);
        }
        return ans;
    }
}
