class SortArrayIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int n : nums) {
            cnt.put(n, cnt.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length];
        for (int i = 0; i < buckets.length; i++) { buckets[i] = new ArrayList<>(); }
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            buckets[e.getValue()].add(e.getKey());
        }

        int[] res = new int[nums.length];
        int resPtr = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i].size() > 0) {
                Collections.sort(buckets[i], Collections.reverseOrder());
                for (int k = 0; k < i; k++) {
                    for (int j = 0; j < buckets[i].size(); j++) {
                        res[resPtr] = buckets[i].get(j);
                        resPtr++;
                    }
                }
            }
        }

        return res;
    }
}
