class FindMinimumRotatedSortedArray {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (l <= r) {
            int curr = l + (r - l + 1) / 2;
            System.out.println(nums[curr]);
            if (nums[curr] > nums[0]) {
                // in left portion now
                if (curr == nums.length - 1) {
                    // array is sorted
                    return nums[0];
                } else {
                    l = curr + 1;
                }
            } else {
                if (nums[curr] < ans) ans = nums[curr];
                r = curr - 1;
            }
            System.out.println(l + " " + r);
        }

        return ans;
    }
}
