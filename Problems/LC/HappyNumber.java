class HappyNumber {
    List<Integer> lst = new ArrayList<>();
    
    int computeFinal(int n) {
        if (n == 1) return n;
        int newN = 0;
        while (n != 0) {
            int digit = n % 10;
            n /= 10;
            newN += digit * digit;
        }
        if (lst.contains(newN)) return -1;
        lst.add(newN);
        return computeFinal(newN);
    }
    
    public boolean isHappy(int n) {
        lst.add(n);
        int res = computeFinal(n);
        return res != -1;
    }
}
