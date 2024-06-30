class IntegerBreak {
    int[] dp;

    int solve(int n) {
        if (dp[n] != -1) return dp[n];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (n - i > 1) {
                res = Math.max(res, Math.max(solve(n - i) * i, (n - i) * i));
            } else if (n - i == 1) {
                res = Math.max(res, i);
            }
        }
        dp[n] = res;
        return res;
    }

    public int integerBreak(int n) {
        dp = new int[n + 5];
        Arrays.fill(dp, -1);
        dp[2] = 1; 
        
        solve(n);
        return dp[n];
    }
}
