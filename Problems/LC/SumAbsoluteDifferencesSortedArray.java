class SumAbsoluteDifferencesSortedArray {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] prefixSum = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int sumAfter = prefixSum[prefixSum.length - 1] - prefixSum[i + 1];
            int nAfter = prefixSum.length - 1 - (i + 1);
            int sumBefore = 0;
            int nBefore = 0;
            if (i > 0) {
                sumBefore = prefixSum[i];
                nBefore = i;
            }
            res[i] = (sumAfter - (nAfter * nums[i])) + ((nBefore * nums[i]) - sumBefore);
        }

        return res;
    }
}
