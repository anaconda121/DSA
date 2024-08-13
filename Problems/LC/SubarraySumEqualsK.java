class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);
        int currSum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            int desired = 0;
            desired = currSum - k;
            res += cnt.getOrDefault(desired, 0);
            cnt.put(currSum, cnt.getOrDefault(currSum, 0) + 1);
        }
        return res;
    }
}
