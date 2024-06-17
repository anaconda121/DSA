public class SumSquareNumbers {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b = c - (int) (a * a);
            if (isPerfectSquare(b)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        long left = 0, right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sq = mid * mid;
            if (sq == num) {
                return true;
            } else if (sq < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
