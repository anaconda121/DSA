class ImplementQueuUsingStacks {
    Stack<Integer> vals;

    public MyQueue() {
        vals = new Stack<>();
    }
    
    public void push(int x) {
        vals.push(x);
    }
    
    public int pop() {
        Stack<Integer> tmp = new Stack<>();
        while (vals.size() > 1) {
            tmp.push(vals.pop());
        }

        int res = vals.pop();
        while (!tmp.isEmpty()) {
            vals.push(tmp.pop());
        }

        return res;
    }
    
    public int peek() {
        Stack<Integer> tmp = new Stack<>();
        while (vals.size() > 1) {
            tmp.push(vals.pop());
        }

        int res = vals.peek();
        while (!tmp.isEmpty()) {
            vals.push(tmp.pop());
        }

        return res;
    }
    
    public boolean empty() {
        return vals.size() == 0;
    }
}
