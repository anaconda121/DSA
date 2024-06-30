class ClimbingStairs {
    int[] vals = new int[50];
    boolean[] computed = new boolean[50];

    int recurse(int n) {
        if (n <= 0) return 0;
        if (computed[n]) return vals[n];
        int res = recurse(n - 1) + recurse(n - 2);
        vals[n] = res;
        computed[n] = true;
        return res;
    }

    public int climbStairs(int n) {
        vals[2] = 2;
        computed[2] = true;
        vals[1] = 1;
        computed[1] = true;
        return recurse(n);
    }
}
