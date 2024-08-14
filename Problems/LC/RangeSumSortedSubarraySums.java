class RangeSumSortedSubarraySums {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod = (int) (1e9 + 7);
        List<Integer> subarraySums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int currSum = 0;
            for (int j = i; j < n; j++) {
                currSum += nums[j];
                subarraySums.add(currSum);
            }
        }

        Collections.sort(subarraySums);

        int sum = 0;
        for (int i = left - 1; i < right; i++) {
            sum = (sum + subarraySums.get(i)) % mod;
        }

        return sum;
    }
}
