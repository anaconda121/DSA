class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        List<List<String>> res = new ArrayList<>();
        String currPref = "";

        for (int i = 0; i < searchWord.length(); i++) {
            currPref += searchWord.charAt(i);
            PriorityQueue<String> recs = new PriorityQueue<>((s1, s2) -> s1.compareTo(s2));

            for (String p : products) {
                if (p.startsWith(currPref)) {
                    recs.offer(p);
                }
            }

            List<String> currRes = new ArrayList<>();
            int len = Math.min(3, recs.size());
            for (int k = 0; k < len; k++) {
                currRes.add(recs.poll());
            }

            res.add(currRes);
        }

        return res;

    }
}
