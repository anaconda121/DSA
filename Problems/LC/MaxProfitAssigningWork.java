class MaxProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[] profitsByDiff = new int[(int) (Math.pow(10, 5)) + 5];
        for (int i = 0; i < difficulty.length; i++) {
            profitsByDiff[difficulty[i]] = Math.max(profitsByDiff[difficulty[i]], profit[i]);
        }

        int maxSoFar = 0;
        for (int i = 0; i < profitsByDiff.length; i++) {
            maxSoFar = Math.max(maxSoFar, profitsByDiff[i]);
            profitsByDiff[i] = maxSoFar;
        }

        int ans = 0;
        for (int i = 0; i < worker.length; i++) {
            ans += profitsByDiff[worker[i]];
        }
        return ans;
    }
}
