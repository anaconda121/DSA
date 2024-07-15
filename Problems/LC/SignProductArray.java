class SignProductArray {
    public int arraySign(int[] nums) {
        for (int i : nums) {
            if (i == 0) return 0;
        }

        int cntNeg = 0;
        for (int i : nums) {
            if (i < 0) cntNeg++;
        }

        if (cntNeg % 2 == 1) return -1;
        return 1;
    }
}
