class LongestRepeatingCharacterReplacement {
    private int recalculateMax(HashMap<Character, Integer> cnt) {
        int max = Integer.MIN_VALUE;
        for (int value : cnt.values()) {
            max = Math.max(max, value);
        }
        return max;
    }

    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> cnt = new HashMap<>();
        
        int l = 0;
        int cntMax = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        for (int r = 0; r < s.length(); r++) {
            int newCnt = cnt.getOrDefault(s.charAt(r), 0) + 1;
            cnt.put(s.charAt(r), newCnt);
            cntMax = Math.max(cntMax, newCnt);
            int length = r - l + 1;
            while (length - cntMax > k) {
                if (cnt.get(s.charAt(l)) > 0) {
                    cnt.put(s.charAt(l), cnt.get(s.charAt(l)) - 1) {
                    if (cnt.get(s.charAt(l)) == cntMax - 1) { cntMax = recalculateMax(cnt); }
                    l++;
                }
                length = r - l + 1;
            }
            ans = Math.max(ans, r - l + 1);
        }
        
        return ans;
    }
}
