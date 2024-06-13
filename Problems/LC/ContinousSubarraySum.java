class ContinousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) return false;
        HashMap<Integer, Integer> prefCnt = new HashMap<>();
        prefCnt.put(0, -1);

        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];

            int desiredMod = currSum % k;
            if (prefCnt.containsKey(desiredMod)) {
                if (i - prefCnt.get(desiredMod) >= 2) { return true; }
            }

            if (!prefCnt.containsKey(currSum % k)) { prefCnt.put(currSum % k, i); }
        }

        return false;
    }
}
