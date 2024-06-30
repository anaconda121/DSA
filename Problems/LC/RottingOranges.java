class RottingOranges {
    int rottenCount = 0;
    int totalOranges = 0;
    int rowLen = 0;
    int colLen = 0;

    void copyGrid(int[][] source, int[][] destination) {
        for (int i = 0; i < source.length; i++) {
            System.arraycopy(source[i], 0, destination[i], 0, source[0].length);
        }
    }

    boolean shouldRot(int r, int c, int[][] grid) {
        if ((r + 1 < rowLen && grid[r + 1][c] == 2) || (r - 1 >= 0 && grid[r - 1][c] == 2)
                || (c + 1 < colLen && grid[r][c + 1] == 2) || (c - 1 >= 0 && grid[r][c - 1] == 2)) {
            return true;
        }
        return false;
    }

    public int orangesRotting(int[][] grid) {
        rowLen = grid.length;
        colLen = grid[0].length;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 2) rottenCount++;
                if (grid[i][j] != 0) totalOranges++;
            }
        }

        int minutes = 0;
        int[][] prevGrid = new int[rowLen][colLen];
        int[][] newGrid = new int[rowLen][colLen];

        while (rottenCount != totalOranges) {
            copyGrid(grid, prevGrid);
            copyGrid(prevGrid, newGrid);

            boolean anyChange = false;

            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < colLen; j++) {
                    if (prevGrid[i][j] == 1 && shouldRot(i, j, prevGrid)) {
                        newGrid[i][j] = 2;
                        rottenCount++;
                        anyChange = true;
                    }
                }
            }

            if (!anyChange) return -1;

            copyGrid(newGrid, grid);
            minutes++;
        }

        return minutes;
    }
}
