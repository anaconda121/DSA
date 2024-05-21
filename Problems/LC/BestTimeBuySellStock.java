class BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int l = 0;
        int r = 1;

        while (r < prices.length) {
            int profit = prices[r] - prices[l];
            if (profit > ans) { ans = profit; }

            if (prices[l] > prices[r]) {
                l++;
            } else {
                r++;
            }
        }

        return ans;
    }
}
