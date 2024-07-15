class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int n = (int) Math.floor(nums.length / 3);
        HashMap<Integer, Integer> cnt = new HashMap<>();

        for (int i : nums) {
            cnt.put(i, cnt.getOrDefault(i, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            if (e.getValue() > n) {
                res.add(e.getKey());
            }
        }
        
        return res;
    }
}
