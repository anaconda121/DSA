class WordLadder {
    class Step {
        String str;
        int level;
        Step(String s, int l) {
            str = s;
            level = l;
        }
    }

    HashMap<String, ArrayList<String>> diffs = new HashMap<>();

    int traverse(String start, String target) {
        Queue<Step> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.add(new Step(start, 1));

        while (!q.isEmpty()) {
            Step curr = q.poll();
            if (curr.str.equals(target)) { return curr.level; }
            if (visited.contains(curr.str)) continue;
            visited.add(curr.str);

            for (String s : diffs.get(curr.str)) {
                q.add(new Step(s, curr.level + 1));
            }
        }

        return 0;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) { return 0; }
        if (!wordSet.contains(beginWord)) { wordList.add(beginWord); }

        for (String first : wordList) {
            ArrayList<String> curr = new ArrayList<>();
            for (String second : wordList) {
                if (!first.equals(second)) {
                    int diff = 0;
                    for (int k = 0; k < Math.min(first.length(), second.length()); k++) {
                        if (first.charAt(k) != second.charAt(k)) { diff++; }
                        if (diff > 1) { break; }
                    }
                    diff += Math.abs(first.length() - second.length());
                    if (diff == 1) { curr.add(second); }
                }
            }
            diffs.put(first, curr);
        }

        return traverse(beginWord, endWord);
    }
}
