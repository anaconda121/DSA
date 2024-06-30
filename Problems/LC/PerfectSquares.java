class PerfectSquares {
    int N = (int) (Math.pow(10, 4)) + 5;
    int[] vals = new int[N];
    boolean[] computed = new boolean[N];

    int solve(int n) {
        if (n < 0) return -1;
        if (computed[n]) return vals[n];
        int res = Integer.MAX_VALUE;
        int lim = (int) Math.ceil(Math.sqrt(n));
        for (int i = 1; i <= lim; i++) {
            int prev = solve(n - i * i);
            if (prev != -1) {
                res = Math.min(res, prev + 1);
            }
        }
        vals[n] = (res == Integer.MAX_VALUE) ? -1 : res;
        computed[n] = true;
        return vals[n];
    }

    public int numSquares(int n) {
        vals[0] = 0; computed[0] = true;
        vals[1] = 1; computed[1] = true;
        return solve(n);
    }
}
