class CountNumberNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> cnts = new HashMap<>();
        cnts.put(0, 1);

        int ans = 0;
        int r = 0;
        int cnt = 0;

        while (r < nums.length) {
            if (nums[r] % 2 == 1) cnt++;
            
            int desired = cnt - k;
            if (cnts.containsKey(desired)) {
                ans += cnts.get(desired);
            }

            cnts.put(cnt, cnts.getOrDefault(cnt, 0) + 1);
            r++;
        }

        return ans;
    }
}
