class DesignBrowserHistory {
    LinkedList<String> l;
    int ptr;

    public BrowserHistory(String homepage) {
        l = new LinkedList<>();
        l.add(homepage);
        ptr = 0;
    }
    
    public void visit(String url) {
        ptr++;
        l.add(ptr, url);
        while (l.size() > ptr + 1) { l.remove(ptr + 1); }
    }
    
    public String back(int steps) {
        int newPtr = ptr - steps;
        if (newPtr < 0) {
            newPtr = 0;
        }
        ptr = newPtr;
        return l.get(ptr);
    }
    
    public String forward(int steps) {
        int newPtr = ptr + steps;
        if (newPtr >= l.size()) {
            newPtr = l.size() - 1;
        }
        ptr = newPtr;
        return l.get(ptr);
    }
}
