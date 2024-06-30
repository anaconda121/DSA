class CoinChange {
    int n = (int) (Math.pow(10, 4)) + 5;
    int[] vals = new int[n];
    boolean[] computed = new boolean[n];

    int solve(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (computed[amount]) return vals[amount];
        int ans = Integer.MAX_VALUE;

        for (int coin : coins) {
            int prev = solve(coins, amount - coin);
            if (prev != -1) {
                ans = Math.min(ans, prev + 1);
            }
        }

        vals[amount] = (ans == Integer.MAX_VALUE) ? -1 : ans;
        computed[amount] = true;
        return vals[amount];
    }

    public int coinChange(int[] coins, int amount) {
        return solve(coins, amount);
    }
}
