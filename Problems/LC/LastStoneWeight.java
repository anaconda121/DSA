class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> s = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int i = 0; i < stones.length; i++) { s.add(stones[i]); }

        while (s.size() > 1) {
            int y = s.poll();
            int x = s.poll();
            if (x != y) {
                s.add(y - x);
            }
        }

        if (s.size() == 0) return 0;
        return s.poll();
    }
}
