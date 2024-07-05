class MaximumNumberRemovableCharacters {
    boolean isSubsequence(String s, String p, int[] removable, int k) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < k; i++) {
            sb.setCharAt(removable[i], '\0');
        }

        int j = 0;
        for (int i = 0; i < sb.length() && j < p.length(); i++) {
            if (sb.charAt(i) == p.charAt(j)) {
                j++;
            }
        }
        return j == p.length();
    }

    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0, right = removable.length;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (isSubsequence(s, p, removable, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
