class CountWaysBuildGoodStrings {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int MOD = (int) Math.pow(10, 9) + 7;
        int N = (int) Math.pow(10, 5) + 5;
        int[] count = new int[N];

        count[0] = 1;
        for (int i = 1; i <= high; i++) {
            if (i - zero >= 0) {
                count[i] += count[i - zero];
            }

            if (i - one >= 0) {
                count[i] += count[i - one];
            }

            count[i] %= MOD;
        }

        long ans = 0;
        for (int i = low; i <= high; i++) {
            ans += count[i];
            ans %= MOD;
        }

        return (int) ans;
    }
}
