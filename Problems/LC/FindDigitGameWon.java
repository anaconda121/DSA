class FindDigitGameWon {
    public boolean canAliceWin(int[] nums) {
        int aliceSingleScore = 0;
        int aliceDoubleScore = 0;

        for (int i : nums) {
            String s = String.valueOf(i);
            if (s.length() == 2) aliceDoubleScore += i;
            else aliceSingleScore += i;
        }

        if (aliceSingleScore == aliceDoubleScore) { return false; }
        return true;
    }
}
