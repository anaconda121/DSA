class MinimumNumberPushesTypeWordII {
    HashMap<Character, Integer> cnt = new HashMap<>();

    ArrayList<Integer> getPushCounts() {
        ArrayList<Integer> res = new ArrayList<>();
        int maxPushes = (cnt.keySet().size() / 8) + 1;
        for (int i = 0; i < cnt.keySet().size() % 8; i++) {
            res.add(maxPushes);
        }
        int currPushes = maxPushes - 1;
        for (int i = 1; i <= cnt.keySet().size() - (cnt.keySet().size() % 8); i++) {
            res.add(currPushes);
            if (i % 8 == 0) currPushes--;
        }
        return res;
    }

    ArrayList<Character>[] bucketSort(int len) {
        ArrayList<Character>[] sorted = new ArrayList[len + 1];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = new ArrayList<>();
        }

        for (Map.Entry<Character, Integer> e : cnt.entrySet()) { 
            sorted[e.getValue()].add(e.getKey());
        }

        return sorted;
    }

    public int minimumPushes(String word) {
        for (Character c : word.toCharArray()) {
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }

        ArrayList<Integer> pushes = getPushCounts();
        ArrayList<Character>[] buckets = bucketSort(word.length());
        int ptr = 0;
        int res = 0;
        for (int i = 0; i < buckets.length; i++) {
            ArrayList<Character> curr = buckets[i];
            if (curr.size() > 0) {
                for (Character c : curr) {
                    res += pushes.get(ptr) * cnt.get(c);
                    ptr++;
                }
            }
        }
        return res;
    }
}
