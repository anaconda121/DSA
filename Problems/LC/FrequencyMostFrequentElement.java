class FrequencyMostFrequentElement {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int l = 0;
        int r = 0;
        long currSum = 0;
        int ans = 0;
        
        while (l <= r && r < nums.length) {
            long currOperationsNeeded = (long) nums[r] * (r - l) - currSum;

            if (currOperationsNeeded <= k) {
                ans = Math.max(ans, r - l + 1);
                currSum += nums[r];
                r++;
            } else {
                if (l == r) { r++; }
                currSum -= nums[l];
                l++;
            }
        }

        return ans;
    }
}
