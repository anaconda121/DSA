class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String s : path.split("/")) {
            if (!s.equals("") && !s.equals(" ")) {
                if (s.equals("..") && stack.size() != 0) { stack.pop(); }
                else if (!s.equals(".") && !s.equals("..")) { stack.push(s); }  
            }
        }

        String ans = "";
        if (stack.size() == 0) return "/";
        while (stack.size() > 0) { ans = "/" + stack.pop() + ans; }
        return ans;
    }
}
