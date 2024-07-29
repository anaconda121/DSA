class PalindromicSubstrings {
    HashMap<String, Boolean> computed = new HashMap<>();

    boolean isPalindromeHelper(String s, int l, int r) {
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l--; r++;
        }
        return true;
    }

    boolean isPalindrome(String s) {
        if (computed.containsKey(s)) return computed.get(s);
        int l = 0; int r = 0;
        if (s.length() % 2 == 0) {
            l = (s.length() - 1) / 2;
            r = s.length() / 2;
        } else {
            l = (s.length() / 2) - 1;
            r = (s.length() / 2) + 1;
        }
        
        boolean res = isPalindromeHelper(s, l, r);
        computed.put(s, res);
        return res;
    }

    public int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                sb.append(s.charAt(j));
                if (isPalindrome(sb.toString())) ans++;      
            }
        }
        return s.length() + ans;
    }
}
