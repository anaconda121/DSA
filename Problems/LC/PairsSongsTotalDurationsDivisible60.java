class PairsSongsTotalDurationsDivisible60 {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> mods = new HashMap<>();
        int res = 0;
        for (int i = 0; i < time.length; i++) {
            int desired = 60 - (time[i] % 60);
            if (desired == 60) desired = 0;
            res += mods.getOrDefault(desired, 0);
            mods.put(time[i] % 60, mods.getOrDefault(time[i] % 60, 0) + 1);
        }
        return res;
    }
}
