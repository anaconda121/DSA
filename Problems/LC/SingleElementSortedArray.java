class SingleElementSortedArray {

    public int singleNonDuplicate(int[] nums) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int midIdx = l + (r - l) / 2;
            int mid = nums[midIdx];
            int before = (midIdx - 1 >= 0) ? nums[midIdx - 1] : Integer.MIN_VALUE;
            int after = (midIdx + 1 < nums.length) ? nums[midIdx + 1] : Integer.MIN_VALUE;

            if (mid != before && mid != after) return mid;
            if (mid == before) {
                int leftRemaining = midIdx - 1;
                if (leftRemaining % 2 == 1) r = midIdx - 1;
                else l = midIdx + 1;
            } else if (mid == after) {
                int rightRemaining = nums.length - (midIdx);
                if (rightRemaining % 2 == 1) l = midIdx + 1;
                else r = midIdx - 1;
            }
        }

        return 0;
        
    }
}
