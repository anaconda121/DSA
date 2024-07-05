class CourseSchedule {
    boolean[] visited;
    HashSet<Integer>[] pre;
    
    void dfs(int curr) {
        if (visited[curr]) return;
        for (int i : pre[curr]) {
            if (!visited[i]) return; 
        }
        visited[curr] = true;
        for (int i = 0; i < pre.length; i++) {
            if (pre[i].contains(curr)) {
                dfs(i);
            }
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        pre = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            pre[i] = new HashSet<Integer>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            pre[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for (int i = 0; i < pre.length; i++) {
            dfs(i);
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) return false;
        }

        return true;
    }
}
