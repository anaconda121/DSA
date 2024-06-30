class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int l = 0; int r = minutes - 1;
        int maxGrumpyCustomers = 0;
        for (int i = l; i < r; i++) {
            if (grumpy[i] == 1) maxGrumpyCustomers += customers[i];
        }

        int currGrumpy = maxGrumpyCustomers;
        while (r < customers.length) {
            if (grumpy[r] == 1) currGrumpy += customers[r];
            maxGrumpyCustomers = Math.max(maxGrumpyCustomers, currGrumpy);
            r += 1;
            if (grumpy[l] == 1) currGrumpy -= customers[l];
            l += 1;
        }

        int happyCustomers = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                happyCustomers += customers[i];
            }
        }

        return happyCustomers + maxGrumpyCustomers;
    }
}
