class FindNumberWinningPlayers {
    public int winningPlayerCount(int n, int[][] pick) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> cnt = new HashMap<>();
            for (int[] p : pick) {
                if (p[0] == i) {
                    cnt.put(p[1], cnt.getOrDefault(p[1], 0) + 1);
                    if (cnt.get(p[1]) > i) {
                        res++;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
