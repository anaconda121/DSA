class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int total = (nums.length * (nums.length + 1)) / 2;
        int l = 0; int r = 0; int curr = 1; int greater = 0;

        if (k <= 1) return 0;

        while (l < nums.length) {
            if (curr < k) {
                if (r < nums.length) {
                    curr *= nums[r];
                    r += 1;
                } else { break; }
            } else {
                greater += 1 + nums.length - r;
                curr /= nums[l];
                l += 1;
            }
        }

        return total - greater;
    }
}
