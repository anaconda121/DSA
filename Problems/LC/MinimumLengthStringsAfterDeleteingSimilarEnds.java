class MinimumLengthStringsAfterDeleteingSimilarEnds {
    public int minimumLength(String s) {

        int l = 0;
        int r = s.length() - 1;
        int ans = s.length();

        while (l < r && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                char c = s.charAt(l);
                while (l <= r && r < s.length() && s.charAt(l) == c) { l++; }
                while (l <= r && r < s.length() && s.charAt(r) == c) { r--; }
                ans = Math.min(ans, r - l + 1);
            } else {
                break;
            }
        }
        
        return ans;
    }
}
