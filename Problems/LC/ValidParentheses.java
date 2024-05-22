class ValidParentheses {
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
}
