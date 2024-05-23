class LRUCache {

    HashMap<Integer, Integer> cache;
    Deque<Integer> keyOperations;
    int maxSize;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        keyOperations = new LinkedList<>();
        maxSize = capacity;
    }

    private void offer(int key) {
        if (cache.containsKey(key)) {
            keyOperations.remove(key);
        }
        keyOperations.offer(key);
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            offer(key);
            return cache.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (!cache.containsKey(key) && cache.size() == maxSize) {
            // remove lru key
            int lruKey = keyOperations.poll();
            cache.remove(lruKey);
        }
        offer(key);
        cache.put(key, value);
        
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
