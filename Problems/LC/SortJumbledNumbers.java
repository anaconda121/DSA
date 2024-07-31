class SortJumbledNumbers {
    TreeMap<Integer, List<Integer>> mappings = new TreeMap<>();

    public int[] sortJumbled(int[] mapping, int[] nums) {
        for (int i : nums) {
            String v = String.valueOf(i);
            StringBuilder r = new StringBuilder();
            for (char j : v.toCharArray()) {
                r.append(mapping[j - '0']);
            }
            int map = Integer.parseInt(r.toString());
            List<Integer> list = mappings.getOrDefault(map, new ArrayList<>());
            list.add(i);
            mappings.put(map, list);
        }

        int[] res = new int[nums.length];
        int ptr = 0;
        for (Map.Entry<Integer, List<Integer>> e : mappings.entrySet()) {
            List<Integer> list = e.getValue();
            for (int num : list) {
                res[ptr] = num;
                ptr++;
            }
        }

        return res;
    }
}
