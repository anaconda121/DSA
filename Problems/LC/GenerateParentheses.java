class GenerateParentheses {
    List<String> ans = new ArrayList<>();

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')' || c == ']' || c == '}') {
                if (st.size() == 0) return false;
                char popped = st.pop();
                if (c == ')' && popped != '(') return false;
                if (c == ']' && popped != '[') return false;
                if (c == '}' && popped != '{') return false;
            } else { st.push(c); }
        }
        return st.size() == 0;
    }

    public void generate(String curr, int depth, int n) {
        if (depth == 2 * n) {
            boolean wellFormed = isValid(curr);
            if (wellFormed) {
                ans.add(curr);
            }
            return;
        }
        generate(curr + ")", depth + 1, n);
        generate(curr + "(", depth + 1, n);
    }

    public List<String> generateParenthesis(int n) {
        generate("", 0, n);
        return ans;
    }
}
