class FindAllDuplicatesArray {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> vals = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int n : nums) {
            if (!vals.contains(n)) {
                vals.add(n);
            } else {
                vals.remove(n);
                res.add(n);
            }
        }
        return res;
    }
}
