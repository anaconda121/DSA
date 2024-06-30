class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        for (int i = 0; i < nums.length; i++) {
            int len = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    len = Math.max(dp[j] + 1, len);
                }
            }
            dp[i] = len;
        }

        int res = 1;
        for (int i : dp) {
            res = Math.max(res, i);
        }

        return res;
    }
}
