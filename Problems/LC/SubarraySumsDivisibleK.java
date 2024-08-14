class SubarraySumsDivisibleK {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> prefCnt = new HashMap<>();
        prefCnt.put(0, 1);

        int currSum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            int desiredMod = currSum % k;
            if (desiredMod < 0) desiredMod += k;
            if (prefCnt.containsKey(desiredMod)) {
                ans += prefCnt.get(desiredMod);
            }
            int cnt = prefCnt.getOrDefault(desiredMod, 0);
            prefCnt.put(desiredMod, cnt + 1);   
        }

        return ans;
    }
}
