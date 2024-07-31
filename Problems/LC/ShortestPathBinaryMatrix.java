class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int res = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        
        if (grid[0][0] == 1 || grid[rowLen - 1][colLen - 1] == 1) { return -1; }

        int[] xDir = new int[]{1, 1, 1, 0, 0, -1, -1, -1};
        int[] yDir = new int[]{1, 0, -1, 1, -1, 1, 0, -1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];

            if (r == rowLen - 1 && c == colLen - 1) { return  d + 1; }

            for (int i = 0; i < xDir.length; i++) {
                int newRow = r + xDir[i];
                int newCol = c + yDir[i];
                if (newRow >= 0 && newRow < rowLen 
                    && newCol >= 0 && newCol < colLen
                    && !visited[newRow][newCol] && grid[newRow][newCol] == 0) {
                    q.add(new int[]{newRow, newCol, d + 1});
                    visited[newRow][newCol] = true;
                }
            }
        }

        return -1;
    }
}
