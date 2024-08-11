class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int curr = nums[i];
            int desired = -1 * curr;
            
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == desired) {
                    List<Integer> triple = new ArrayList<>();
                    triple.add(curr); triple.add(nums[l]); triple.add(nums[r]);
                    res.add(triple);
                    int prev = nums[l];
                    while (nums[l] == prev && l < r) { l++; }
                } else if (nums[l] + nums[r] > desired) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }
}
