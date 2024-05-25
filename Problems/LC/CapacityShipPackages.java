class CapacityShipPackages {

    int f(int[] weights, int possibleC) {
        int r = 0; int days = 1; int ctr = 0;

        while (r < weights.length) {
            if (ctr + weights[r] <= possibleC) {
                ctr += weights[r];
                r += 1;
            } else {
                ctr = 0;
                days += 1;
            }
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();
        int ans = (int) (Math.pow(10, 9));

        while (l <= r) {
            int mid = l + (r - l + 1) / 2;
            int requiredDays = f(weights, mid);
            
            if (requiredDays > days) {
                l = mid + 1;
            } else {
                ans = Math.min(ans, mid);
                r = mid - 1;
            }
        }

        return ans;
    }
}
