class PrisonAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<String, Integer> seen = new HashMap<>();
        boolean hasCycle = false;
        int cycleLength = 0;

        for (int i = 0; i < n; i++) {
            int[] nextCells = new int[8];
            for (int j = 1; j < cells.length - 1; j++) {
                nextCells[j] = (cells[j - 1] == cells[j + 1]) ? 1 : 0;
            }

            String state = Arrays.toString(nextCells);
            if (seen.containsKey(state)) {
                hasCycle = true;
                cycleLength = i - seen.get(state);
                break;
            } else { seen.put(state, i); }
            cells = nextCells;
        }
        
        if (hasCycle) {
            n = n % cycleLength;
            for (int i = 0; i <n; i++) {
                int[] nextCells = new int[8];
                for (int j = 1; j < cells.length - 1; j++) {
                    nextCells[j] = (cells[j - 1] == cells[j + 1]) ? 1 : 0;
                }
                cells = nextCells;
            }
        }

        return cells;
    }
}
