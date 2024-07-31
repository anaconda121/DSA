import java.math.BigInteger;

class SplittingStringConsecutiveDescendingValues {
    boolean res = false;
    
    void backtrack(int start, String s, BigInteger prev) {
        if (start == s.length()) {
            res = true;
            return;
        }
        
        int end = (start == 0) ? s.length() - 1 : s.length();
        for (int i = start; i < end; i++) {
            String currSplit = s.substring(start, i + 1);
            BigInteger curr = new BigInteger(currSplit);
            if (prev.equals(BigInteger.valueOf(-1)) || curr.add(BigInteger.ONE).equals(prev)) {
                backtrack(i + 1, s, curr);
            }
        }
    }

    public boolean splitString(String s) {
        backtrack(0, s, BigInteger.valueOf(-1));
        return res;
    }
}
