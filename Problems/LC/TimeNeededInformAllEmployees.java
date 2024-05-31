class TimeNeededInformAllEmployees {

    int ans = 0;
    boolean[] visited;

    void dfs(int curr, int currInform, List<Integer>[] subordinates, int[] informTime) {
        if (visited[curr]) return;
        visited[curr] = true;
        ans = Math.max(ans, currInform);

        for (int sub : subordinates[curr]) {
            if (!visited[sub]) {
                dfs(sub, currInform + informTime[curr], subordinates, informTime);
            }
        }
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] subordinates = new List[n];
        for (int i = 0; i < n; i++) {
            subordinates[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                subordinates[manager[i]].add(i);
            }
        }

        visited = new boolean[n];
        dfs(headID, 0, subordinates, informTime);
        return ans;
    }
}
