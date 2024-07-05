class CountSubIslands {

    class Pair {
        int x; int y;
        Pair(int _x, int _y) {
            x = _x; y = _y;
        }
    }

    int rowLen;
    int colLen;
    ArrayList<Pair> currGrid2Island;
    ArrayList<ArrayList<Pair>> grid2Islands;
    boolean[][] visited;
    boolean[][] grid1Islands;

    void floodfill(int r, int c, int[][] grid, boolean isGrid2) {
        if (r < 0 || r >= rowLen || c < 0 || c >= colLen 
            || visited[r][c] 
            || grid[r][c] != 1) { return; }

        visited[r][c] = true;

        if (isGrid2) {
            currGrid2Island.add(new Pair(r, c));
        } else {
            grid1Islands[r][c] = true;
        }
        
        floodfill(r, c + 1, grid, isGrid2);
        floodfill(r, c - 1, grid, isGrid2);
        floodfill(r + 1, c, grid, isGrid2);
        floodfill(r - 1, c, grid, isGrid2);
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        rowLen = grid1.length;
        colLen = grid1[0].length;
        currGrid2Island = new ArrayList<Pair>();
        grid2Islands = new ArrayList<ArrayList<Pair>>();
        visited = new boolean[rowLen][colLen];
        grid1Islands = new boolean[rowLen][colLen];

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (!visited[i][j] && grid1[i][j] == 1) {
                    floodfill(i, j, grid1, false);
                }
            }
        }

        visited = new boolean[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (!visited[i][j] && grid2[i][j] == 1) {
                    currGrid2Island = new ArrayList<Pair>();
                    floodfill(i, j, grid2, true);
                    grid2Islands.add(currGrid2Island);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < grid2Islands.size(); i++) {
            List<Pair> curr = grid2Islands.get(i);
            boolean subIsland = true;
            for (Pair j : curr) {
                if (!grid1Islands[j.x][j.y]) subIsland = false;
            }
            if (subIsland) res++;
        }

        return res;
    }
}
