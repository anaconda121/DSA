class SpecialArrayXElementsGreaterThanEqualX {

    int f(int[] nums, int mid) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= mid) cnt++;
        }
        return cnt;
    }

    public int specialArray(int[] nums) {
        int l = 0;
        int r = 1000;

        while (l <= r) {
            int mid = l + (r - l + 1) / 2;
            int x = f(nums, mid);
            if (x == mid) {
                return mid;
            } else if (x > mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return -1;
    }
}
