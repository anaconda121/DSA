class LongestContinuousSubarrayWithAbsoluteDiffLessEqualLimit {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        int l = 0, ans = 0;

        for (int r = 0; r < nums.length; r++) {
            minQueue.offer(nums[r]);
            maxQueue.offer(nums[r]);

            while (maxQueue.peek() - minQueue.peek() > limit) {
                if (minQueue.contains(nums[l])) {
                    minQueue.remove(nums[l]);
                }
                if (maxQueue.contains(nums[l])) {
                    maxQueue.remove(nums[l]);
                }
                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
