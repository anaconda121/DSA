class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sM = new HashMap<>();
        HashMap<Character, Integer> tM = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sM.put(s.charAt(i), sM.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            tM.put(t.charAt(i), tM.getOrDefault(t.charAt(i), 0) + 1);
        }

        if (sM.size() != tM.size()) return false;

        for (Map.Entry<Character, Integer> e : sM.entrySet()) {
            if (!tM.containsKey(e.getKey()) || !tM.get(e.getKey()).equals(e.getValue())) return false;
        }

        return true;
    }
}
