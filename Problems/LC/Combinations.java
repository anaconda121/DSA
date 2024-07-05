class Combinations {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    void backtrack(int n, int k, List<Integer> curr, int start) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i <= n; i++) {
            curr.add(i);
            backtrack(n, k, curr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, new ArrayList<Integer>(), 1);
        return res;
    }
}
