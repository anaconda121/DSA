class MinimumDeletionsMakeStringBalanced {
    public int minimumDeletions(String s) {
        int[] aPref = new int[s.length() + 1];
        int[] bPref = new int[s.length() + 1];

        for (int i = 1; i < aPref.length; i++) {
            if (s.charAt(i - 1) == 'a') {
                aPref[i] = aPref[i - 1] + 1;
                bPref[i] = bPref[i - 1];
            } else {
                bPref[i] = bPref[i - 1] + 1;
                aPref[i] = aPref[i - 1];
            }
        }

        int res = aPref[aPref.length - 1];
        for (int i = 0; i < s.length(); i++) {
            int deletionsNeeded = bPref[i] + (aPref[aPref.length - 1] - aPref[i]);
            res = Math.min(res, deletionsNeeded);
        }
        res = Math.min(res, bPref[bPref.length - 1]);
        return res;
    }
}
