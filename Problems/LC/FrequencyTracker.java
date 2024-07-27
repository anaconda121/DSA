class FrequencyTracker {
    HashMap<Integer, Integer> cnt;
    List<Integer>[] buckets;

    public FrequencyTracker() {
        cnt = new HashMap<>();
        buckets = new List[(int) Math.pow(10, 5) + 5];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
    }
    
    public void add(int number) {
        int newCnt = cnt.getOrDefault(number, 0) + 1;
        int prevCnt = newCnt - 1;
        cnt.put(number, newCnt);
        if (prevCnt > 0) {
            int removedElement = buckets[prevCnt].remove(buckets[prevCnt].size() - 1);
            buckets[newCnt].add(removedElement);
        } else {
            buckets[newCnt].add(number);
        }
    }
    
    public void deleteOne(int number) {
        if (cnt.containsKey(number)) {
            int newCnt = cnt.get(number) - 1;
            int prevCnt = newCnt + 1;
            if (newCnt == 0) cnt.remove(number);
            else cnt.put(number, newCnt);
            int transfer = buckets[prevCnt].remove(buckets[prevCnt].size() - 1);
            buckets[newCnt].add(transfer);
        }
    }
    
    public boolean hasFrequency(int frequency) {
        return buckets[frequency].size() > 0;
    }
}
