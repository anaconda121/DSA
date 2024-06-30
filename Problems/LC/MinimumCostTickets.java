class MinimumCostTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[365 + 5];
        boolean[] needTravel = new boolean[365 + 5];

        for (int i = 0; i < days.length; i++) {
            needTravel[days[i]] = true;
        }

        for (int i = 1; i <= 365; i++) {
            if (needTravel[i]) {
                int costOne = dp[i - 1] + costs[0];
                int costSeven = (i >= 7) ? dp[i - 7] + costs[1] : costs[1];
                int costThirty = (i >= 30) ? dp[i - 30] + costs[2] : costs[2];
                dp[i] = Math.min(costOne, Math.min(costSeven, costThirty));
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[days[days.length - 1]];
    }
}
