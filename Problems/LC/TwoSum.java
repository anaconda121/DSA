class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int desired = target - nums[i];
            if (cnt.containsKey(desired)) {
                res[0] = cnt.get(desired);
                res[1] = i;
                break;
            }
            cnt.put(nums[i], i);
        }
        
        return res;
    }
}
