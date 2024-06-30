class MaxAreaIsland {
    boolean[][] visited;
    int rowLen;
    int colLen;
    int size = 0;
    
    void floodfill(int r, int c, int color, int[][] grid) {
        if (r < 0 || r >= rowLen || c < 0 || c >= colLen 
            || visited[r][c] 
            || grid[r][c] != color) { return; }

        visited[r][c] = true;
        size++;
        
        floodfill(r, c + 1, color, grid);
        floodfill(r, c - 1, color, grid);
        floodfill(r + 1, c, color, grid);
        floodfill(r - 1, c, color, grid);
    }

    public int maxAreaOfIsland(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        rowLen = grid.length;
        colLen = grid[0].length;
        
        int res = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    size = 0;
                    floodfill(i, j, 1, grid);
                    res = Math.max(res, size);
                }
            }
        }

        return res;
    }
}
