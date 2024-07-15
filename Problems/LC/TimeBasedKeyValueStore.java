class TimeBasedKeyValueStore {
    class Times {
        List<Integer> t = new ArrayList<>();
        List<String> v = new ArrayList<>();
        void add(int _t, String _v) {
            t.add(_t); v.add(_v);
        }
    }

    HashMap<String, Times> store;

    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Times ti = store.getOrDefault(key, new Times());
        ti.add(timestamp, value);
        store.put(key, ti);
    }
    
    public String get(String key, int timestamp) {
        Times ti = store.get(key);
        if (ti == null) return "";
        int l = 0;
        int r = ti.t.size() - 1;
        String potentialRes = "";
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (ti.t.get(m) == timestamp) { return ti.v.get(m); } 
            else if (ti.t.get(m) > timestamp) {  r = m - 1; } 
            else {
                potentialRes = ti.v.get(m);
                l = m + 1;
            }
        }
        return potentialRes;
    }
}
