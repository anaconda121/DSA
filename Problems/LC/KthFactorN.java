class KthFactorN {
    public int kthFactor(int n, int k) {
        ArrayList<Integer> factors = new ArrayList<>();
        int cnt = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
                cnt++;
                if (n / i != i) {
                    cnt++;
                }
            }
        }

        if (k > cnt) return -1;
        if (k <= factors.size()) return factors.get(k - 1);
        int complement = cnt - k;
        return n / factors.get(complement);
    }
}
