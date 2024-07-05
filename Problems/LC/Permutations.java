class Permutations {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    void backtrack(int n, List<Integer> curr, Set<Integer> nums) {
        if (curr.size() == n) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i : nums) {
            curr.add(i);
            Set<Integer> tmp = new HashSet<>(nums);
            tmp.remove(i);
            backtrack(n, curr, tmp);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        backtrack(nums.length, new ArrayList<>(), numSet);
        return res;
    }
}
