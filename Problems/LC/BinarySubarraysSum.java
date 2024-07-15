class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        int currSum = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            int desired = currSum - goal;
            if (currSum == goal) res += 1;
            res += cnt.getOrDefault(desired, 0);
            cnt.put(currSum, cnt.getOrDefault(currSum, 0) + 1);
        }

        return res;
    }
}
