class NumberClosedIslands {
    int rowLen;
    int colLen;
    boolean valid = true;
    boolean[][] visited;

    boolean checkEnclosed(int r, int c) { return (r > 0 && r < rowLen - 1 && c > 0 && c < colLen - 1); }

    void floodfill(int r, int c, int[][] grid) {
        if (r < 0 || r >= rowLen || c < 0 || c >= colLen || visited[r][c] || grid[r][c] == 1) {
            return;
        }

        visited[r][c] = true;
        if (!checkEnclosed(r, c)) valid = false;

        floodfill(r, c + 1, grid);
        floodfill(r, c - 1, grid);
        floodfill(r + 1, c, grid);
        floodfill(r - 1, c, grid);
    }

    public int closedIsland(int[][] grid) {
        rowLen = grid.length;
        colLen = grid[0].length;
        visited = new boolean[rowLen][colLen];

        int res = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (i != 0 && i != rowLen - 1 && j != 0 && j != colLen - 1 
                    && !visited[i][j] && grid[i][j] == 0) {
                    floodfill(i, j, grid);
                    if (valid) res++;
                    valid = true;
                }
            }
        }
        return res;
    }
}
