class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;
            String curr = ""+s.charAt(i);
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (l != r) {
                    curr = s.charAt(l) + curr + s.charAt(r);
                }
                l--;
                r++;
                
            }

            if (curr.length() > res.length()) res = curr;

            l = i;
            r = i + 1;
            curr = "";
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                curr = s.charAt(l) + curr + s.charAt(r);
                l--;
                r++;
            }

            if (curr.length() > res.length()) res = curr;
        }

        return res;
    }
}
