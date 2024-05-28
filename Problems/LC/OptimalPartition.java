class OptimalPartition {
    public int partitionString(String s) {
        int l = 0, r = 0, cnt = 0;
        HashMap<Character, Integer> charCount = new HashMap<>();
        
        while (r < s.length()) {
            char currChar = s.charAt(r);            
            charCount.put(currChar, charCount.getOrDefault(currChar, 0) + 1);
            if (charCount.get(currChar) > 1) {
                cnt++;
                charCount.clear();
                l = r;
                charCount.put(currChar, 1);
            }
            
            r++;
        }
        
        if (!charCount.isEmpty()) {
            cnt++;
        }
        
        return cnt;
    }
}
