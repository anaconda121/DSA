class WordBreakII {
    List<String> res = new ArrayList<>();
    HashSet<String> words = new HashSet<>();

    void recurse(String s, int idx, StringBuilder curr) {
        if (idx == s.length()) {
            res.add(curr.toString());
            return;
        }

        StringBuilder sub = new StringBuilder();
        for (int i = idx; i < s.length(); i++) {
            sub.append(s.charAt(i));
            if (words.contains(sub.toString())) {
                if (curr.length() == 0) { recurse(s, i + 1, sub); } 
                else {
                    StringBuilder newCurr = new StringBuilder(curr);
                    newCurr.append(" ").append(sub);
                    recurse(s, i + 1, newCurr);
                }
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        for (int i = 0; i < wordDict.size(); i++) {
            words.add(wordDict.get(i));
        }
        recurse(s, 0, new StringBuilder());
        return res;
    }
}
