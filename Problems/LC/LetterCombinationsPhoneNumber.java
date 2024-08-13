class LetterCombinationsPhoneNumber {
    static HashMap<Integer, String> mappings = new HashMap<>();
    List<String> res = new ArrayList<>();

    static {
        String[] letters = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < letters.length; i++) {
            mappings.put(2 + i, letters[i]);
        }
    }

    void backtrack(String digits, int idx, StringBuilder curr) {
        if (idx == digits.length()) {
            if (idx > 0) { res.add(curr.toString()); }
            return;
        }

        int currDigit = Character.getNumericValue(digits.charAt(idx));
        String letters = mappings.get(currDigit);
        for (int i = 0; i < letters.length(); i++) {
            backtrack(digits, idx + 1, new StringBuilder(curr).append(letters.charAt(i)));
        }
    }

    public List<String> letterCombinations(String digits) {
        
        backtrack(digits, 0, new StringBuilder());
        return res;
    }
}
