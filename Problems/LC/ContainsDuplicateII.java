class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (cnt.containsKey(nums[i])) {
                if (Math.abs(i - cnt.get(nums[i])) <= k) return true;
            }
            cnt.put(nums[i], i);
        }
        return false;
    }
}
