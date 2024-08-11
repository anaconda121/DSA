class ShortestBridge {
    ArrayList<int[]> islandCoords = new ArrayList<>();
    int[][] islandOne;

    private void floodFill(int r, int c, int[][] grid, int rowLen, int colLen, boolean[][] visited) {
        if (r < 0 || r >= rowLen || c < 0 || c >= colLen || visited[r][c] || grid[r][c] == 0) {
            return;
        }

        islandOne[r][c] = 1;
        islandCoords.add(new int[]{r, c});
        visited[r][c] = true;

        floodFill(r, c + 1, grid, rowLen, colLen, visited);
        floodFill(r, c - 1, grid, rowLen, colLen, visited);
        floodFill(r + 1, c, grid, rowLen, colLen, visited);
        floodFill(r - 1, c, grid, rowLen, colLen, visited);
    }

    private int bfsFloodFill(int[][] grid, int[] start) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];

        int[] xDir = {0, 0, 1, -1};
        int[] yDir = {-1, 1, 0, 0};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];

            if (grid[r][c] == 1 && islandOne[r][c] == 0) {
                return d;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = r + xDir[i];
                int newCol = c + yDir[i];
                if (newRow >= 0 && newRow < rowLen && newCol >= 0 && newCol < colLen && !visited[newRow][newCol]) {
                    queue.add(new int[]{newRow, newCol, d + 1});
                    visited[newRow][newCol] = true;
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    public int shortestBridge(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        islandOne = new int[rowLen][colLen];
        boolean[][] visited = new boolean[rowLen][colLen];

        boolean foundIsland = false;
        for (int i = 0; i < rowLen && !foundIsland; i++) {
            for (int j = 0; j < colLen && !foundIsland; j++) {
                if (grid[i][j] == 1) {
                    floodFill(i, j, grid, rowLen, colLen, visited);
                    foundIsland = true;
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;
        for (int[] coord : islandCoords) {
            minDistance = Math.min(minDistance, bfsFloodFill(grid, coord));
        }
        
        return minDistance - 1;
    }
}
