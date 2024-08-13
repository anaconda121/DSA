class NearestExitEntranceMaze {
    int bfsFloodfill(char[][] grid, int[] s) {
        int res = Integer.MAX_VALUE;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];

        int[] xDir = new int[]{1, -1, 0, 0};
        int[] yDir = new int[]{0, 0, 1, -1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{s[0], s[1], 0}); // (r, c, distance)
        visited[s[0]][s[1]] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];

            if (r != s[0] || c != s[1]) {
                if (r == 0 || r == rowLen - 1 || c == 0 || c == colLen - 1) {
                    res = Math.min(res, d);
                }
            }

            for (int i = 0; i < xDir.length; i++) {
                int newRow = r + xDir[i];
                int newCol = c + yDir[i];
                if (newRow >= 0 && newRow < rowLen
                        && newCol >= 0 && newCol < colLen
                        && !visited[newRow][newCol] && grid[newRow][newCol] == '.') {
                    q.add(new int[]{newRow, newCol, d + 1});
                    visited[newRow][newCol] = true;
                }
            }
        }

        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        return bfsFloodfill(maze, entrance);
    }
}
