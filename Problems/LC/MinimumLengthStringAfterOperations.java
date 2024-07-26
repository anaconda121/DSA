class MinimumLengthStringAfterOperations {
    public int minimumLength(String s) {
        if (s.length() < 3) return s.length();

        HashMap<Character, Integer> cnt = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            cnt.put(s.charAt(i), cnt.getOrDefault(s.charAt(i), 0) + 1);
        }

        int changes = 0;
        for (Map.Entry<Character, Integer> e : cnt.entrySet()) {
            if (e.getValue() >= 3) { 
                if (e.getValue() % 2 == 0) changes += e.getValue() - 2;
                else changes += e.getValue() - 1;
            }
        }

        return s.length() - changes;
    }
}
