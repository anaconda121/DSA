class Sqrt(x) {
    public int mySqrt(int x) {
        int res = -1;
        long minDiff = Long.MAX_VALUE;
        long i = 0;
        while (i * i <= x) {
            long diff = (long) (x - (i * i));
            if (diff >= 0 && diff < minDiff) {
                res = (int) i;
                minDiff = diff;
            }
            i++;
        }
        return res;
    }
}
