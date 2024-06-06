class RemovingStarsFromString {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') { stack.pop(); } 
            else { stack.push(s.charAt(i)); }
        }

        String ans = "";
        while (stack.size() > 0) { ans = stack.pop() + ans; }
        return ans;
    }
}
