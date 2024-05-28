class InsertDeleteGetRandomO1 {
    Set<Integer> s;
    ArrayList<Integer> a;
    Random rand;

    public RandomizedSet() {
        s = new HashSet<>();
        a = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (!s.contains(val)) {
            s.add(val);
            a.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if (s.contains(val)) {
            s.remove(val);
            a.remove((Integer) val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int r = rand.nextInt(a.size());
        return a.get(r);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
