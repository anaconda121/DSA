class MinCostClimbingStairs {
    int N = 1000 + 5;
    int[] dp;

    int dfs(int step, int[] cost) {
        if (step < 0) return 0;
        if (step == 0 || step == 1) return 0;
        if (dp[step] != -1) return dp[step];
        
        int oneStep = dfs(step - 1, cost) + cost[step - 1];
        int twoStep = dfs(step - 2, cost) + cost[step - 2];
        
        dp[step] = Math.min(oneStep, twoStep);
        return dp[step];
    }

    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp, -1);
        int n = cost.length;
        return Math.min(dfs(n - 1, cost) + cost[n - 1], 
                        dfs(n - 2, cost) + cost[n - 2]);
    }
}
