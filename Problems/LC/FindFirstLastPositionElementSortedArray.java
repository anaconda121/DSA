class FindFirstLastPositionElementSortedArray {
    int binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int closestIdx = Integer.MAX_VALUE;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                closestIdx = Math.min(closestIdx, m);
                r = m - 1;
            } else if (nums[m] > target) { r = m - 1; } 
            else {  l = m + 1; }
        }

        if (closestIdx == Integer.MAX_VALUE) return -1;
        return closestIdx;
    }

    public int[] searchRange(int[] nums, int target) {
        int findTarget = binarySearch(nums, target);
        if (findTarget == -1) {
            return new int[]{-1, -1};
        }

        int[] res = new int[2];
        Arrays.fill(res, -1);
        res[0] = findTarget;
        for (int i = findTarget; i < nums.length; i++) {
            if (nums[i] != target) {
                res[1] = i - 1;
                break;
            }
        }

        if (res[1] == -1) res[1] = nums.length - 1;

        return res;
    }
}
