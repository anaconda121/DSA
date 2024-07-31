class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();
    
    void backtrack(int[] nums, int startIdx, int target, List<Integer> curr) {
        if (target == 0) {
            res.add(curr);
            return;
        }
        
        for (int i = startIdx; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                List<Integer> newCurr = new ArrayList<>(curr);
                newCurr.add(nums[i]);
                backtrack(nums, i, target - nums[i], newCurr);
            }
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, target, new ArrayList<>());
        return res;
    }
}
