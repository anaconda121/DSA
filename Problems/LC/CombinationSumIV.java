class CombinationSumIV {
    int n = 1005;
    int[] vals = new int[n];
    boolean[] computed = new boolean[n];

    int recurse(int[] nums, int n) {
        if (n < 0) return 0;
        if (computed[n]) return vals[n];

        int ans = 0;
        for (int num : nums) {
            ans += recurse(nums, n - num);
        }

        vals[n] = ans;
        computed[n] = true;
        return ans;
    }

    public int combinationSum4(int[] nums, int target) {
        vals[0] = 1; computed[0] = true;
        recurse(nums, target);
        return vals[target];
    }
}
