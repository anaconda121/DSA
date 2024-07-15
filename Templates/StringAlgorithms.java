public class StringAlgorithms {


    /**
     * Check if `p` is a subsequence of `s`.
     * Subsequence is defined as a new string generated from an old one by deleting some
     * characters but not changing the order of characters.
     * */
    boolean checkSubsequence(String s, String p) {
        int j = 0;
        for (int i = 0; i < s.length() && j < p.length(); i++) {
            if (s.charAt(i) == p.charAt(j)) {
                j++;
            }
        }
        return j == p.length();
    }

}
