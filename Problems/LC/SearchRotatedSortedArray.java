class SearchRotatedSortedArray {
    int binarySearch(int[] nums, int s, int e, int target) {
        int l = s;
        int r = e - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return m;
            else if (nums[m] > target) r = m - 1;
            else l = m + 1;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        if (nums.length == 1) return (nums[0] == target) ? 0 : -1;

        int dipIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] < nums[i - 1]) {
                dipIdx = i;
                break;
            }
        }

        int firstHalf = binarySearch(nums, 0, dipIdx, target);
        if (firstHalf != -1) return firstHalf;

        int secondHalf = binarySearch(nums, dipIdx, nums.length, target);
        if (secondHalf != -1) return secondHalf;
        return -1;
    }
}
