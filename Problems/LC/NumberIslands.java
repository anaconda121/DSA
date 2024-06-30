class NumberIslands {
    int[][] terrain;
    boolean[][] visited;
    int rowLen;
    int colLen;
    
    void floodfill(int r, int c, int color) {
        if (r < 0 || r >= rowLen || c < 0 || c >= colLen 
            || visited[r][c] 
            || terrain[r][c] != color) { return; }

        visited[r][c] = true;
        
        floodfill(r, c + 1, color);
        floodfill(r, c - 1, color);
        floodfill(r + 1, c, color);
        floodfill(r - 1, c, color);
    }

    public int numIslands(char[][] grid) {
        terrain = new int[grid.length][grid[0].length];
        visited = new boolean[grid.length][grid[0].length];
        rowLen = grid.length;
        colLen = grid[0].length;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                terrain[i][j] = grid[i][j] - '0';
            }
        }
        
        int islands = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (!visited[i][j] && terrain[i][j] == 1) {
                    islands++;
                    floodfill(i, j, 1);
                }
            }
        }

        return islands;
    }
}
