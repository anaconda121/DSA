class RestoreIPAddresses {
    List<String> res = new ArrayList<>();

    boolean checkValid(String s) {
        if (s.charAt(0) == '0' && s.length() > 1 || s.length() > 3) return false;
        int sInt = Integer.parseInt(s);
        if (sInt > 255) return false;
        return true;
    }

    void split(String s, int lastIdx, int numGroups, String curr) {
        if (numGroups == 4) {
            if (curr.length() == s.length() + 3) { res.add(curr); }
            return;
        }

        for (int i = lastIdx; i < s.length() - 3 + numGroups; i++) {
            String newCurr = curr;
            String potentialAdd = s.substring(lastIdx, i + 1);
            if (!checkValid(potentialAdd)) continue;
            if (numGroups == 3) { newCurr += (s.substring(lastIdx, i + 1)); } 
            else { newCurr += (s.substring(lastIdx, i + 1) + "."); }
            split(s, i + 1, numGroups + 1, newCurr);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        split(s, 0, 0, "");
        return res;
    }
}
