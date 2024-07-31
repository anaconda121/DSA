class PathMaximumGold {
    int res = 0;
    int rowLen;
    int colLen;
    boolean[][] visited;

    void floodfill(int r, int c, int score, int[][] grid) {
        if (r < 0 || r >= rowLen || c < 0 || c >= colLen || visited[r][c] || grid[r][c] == 0) {
            return;
        }

        visited[r][c] = true;
        score += grid[r][c];
        res = Math.max(res, score);

        floodfill(r, c + 1, score, grid);
        floodfill(r, c - 1, score, grid);
        floodfill(r + 1, c, score, grid);
        floodfill(r - 1, c, score, grid);

        visited[r][c] = false;
    }

    public int getMaximumGold(int[][] grid) {
        rowLen = grid.length;
        colLen = grid[0].length;
        visited = new boolean[rowLen][colLen];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) { floodfill(i, j, 0, grid); }
            }
        }
        return res;
    }
}
