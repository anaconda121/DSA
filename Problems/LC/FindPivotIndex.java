class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int[] psum = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            psum[i + 1] = psum[i] + nums[i];
        }

        for (int i = 1; i < psum.length; i++) {
            int currSumRight = psum[psum.length - 1] - psum[i - 1];
            int currSumLeft = psum[i];
            if (currSumRight == currSumLeft) return i - 1;
        }

        return -1;
    }
}
