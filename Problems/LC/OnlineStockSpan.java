class OnlineStockSpan {

    Stack<Integer> s;

    public OnlineStockSpan() {
        s = new Stack<>();
    }
    
    public int next(int price) {
        int d = 1;
        for (int i = s.size() - 1; i >= 0; i--) {
            int p = s.get(i);
            if (p > price) break;
            d++;
        }
        s.push(price);
        return d;
    } 
}
