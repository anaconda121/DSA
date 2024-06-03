class AppendCharactersStringMakeSubsequence {
    public int appendCharacters(String s, String t) {
        int sim = 0;
        for (int i = 0; i < s.length(); i++) {
            if (sim >= t.length()) break;
            if (s.charAt(i) == t.charAt(sim)) sim++;
        }
        return t.length() - sim;
    }
}
