class DesignBitset {
    int[] BIT;
    ArrayList<Integer> flipTimes;
    HashMap<Integer, Integer> lastEdited;
    int oneCnt;
    int operations;

    public Bitset(int size) {
        BIT = new int[size];
        flipTimes = new ArrayList<>();
        lastEdited = new HashMap<>();
        oneCnt = 0;
        operations = 0;
    }

    private int findNumFlips(int time) {
        if (flipTimes.size() == 0) return 0;
        else if (flipTimes.get(0) >= time) return flipTimes.size();
        else if (flipTimes.get(flipTimes.size() - 1) <= time) return 0;

        int l = 0;
        int r = flipTimes.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m < flipTimes.size() - 1 && flipTimes.get(m) <= time && flipTimes.get(m + 1) >= time) {
                return flipTimes.size() - m - 1;
            } else if (flipTimes.get(m) > time) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    private int computeNewBit(int org, int numFlips) {
        return (numFlips % 2 == 0) ? org : 1 - org;
    }
    
    public void fix(int idx) {
        int numFlips = findNumFlips(lastEdited.getOrDefault(idx, 0));
        int newBit = computeNewBit(BIT[idx], numFlips);
        BIT[idx] = newBit;
        if (newBit == 0) {
            BIT[idx] = 1;
            oneCnt++;
            
        }
        lastEdited.put(idx, operations);
        operations++;
    }
    
    public void unfix(int idx) {
        int numFlips = findNumFlips(lastEdited.getOrDefault(idx, 0));
        int newBit = computeNewBit(BIT[idx], numFlips);
        BIT[idx] = newBit;
        if (newBit == 1) {
            BIT[idx] = 0;
            oneCnt--;
        }
        lastEdited.put(idx, operations);
        operations++;
    }
    
    public void flip() {
        flipTimes.add(operations);
        operations++;
        oneCnt = BIT.length - oneCnt;
    }
    
    public boolean all() {
        operations++;
        return oneCnt == BIT.length;
    }
    
    public boolean one() {
        operations++;
        return oneCnt >= 1;
    }
    
    public int count() {
        operations++;
        return oneCnt;
    }
    
    public String toString() {
        // System.out.println(operations + " " + toString());
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < BIT.length; i++) {
            int numFlips = findNumFlips(lastEdited.getOrDefault(i, 0));
            int newBit = computeNewBit(BIT[i], numFlips);
            res.append(newBit);
        }
        return res.toString();
    }
}
