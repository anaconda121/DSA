class FindPeakElement {

    boolean peak(int before, int curr, int after) {
        return curr > before && curr > after;
    }

    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int before = (mid - 1 >= 0) ? nums[mid - 1] : Integer.MIN_VALUE;
            int after = (mid + 1 < nums.length) ? nums[mid + 1] : Integer.MIN_VALUE;

            if (peak(before, nums[mid], after)) { return mid; }
            else if (after > nums[mid]) {
                l = mid + 1;
            } else {
                // before > mid
                r = mid - 1;
            }
        } 

        return 0;
    }
}
