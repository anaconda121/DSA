class MinimumRemoveMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> st = new Stack<>();
        Stack<Integer> startSt = new Stack<>();

        int ptr = 0;
        while (ptr < s.length()) {
            if (s.charAt(ptr) != '(' && s.charAt(ptr) != ')') {
                res.append(s.charAt(ptr));
            } else if (s.charAt(ptr) == ')') {
                if (!st.isEmpty() && st.pop() == '(') {
                    if (!startSt.isEmpty()) {
                        int startIndex = startSt.pop();
                        res.insert(startIndex, '(');
                    }
                    res.append(')');
                }
            } else {
                startSt.push(res.length());
                st.push('(');
            }
            ptr++;
        }

        return res.toString();
    }
}
