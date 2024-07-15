public class GraphAlgorithms {

    void floodfill(int r, int c, int[][] grid, int rowLen, int colLen, boolean[][] visited) {
        if (r < 0 || r >= rowLen || c < 0 || c >= colLen || visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        floodfill(r, c + 1, grid, rowLen, colLen, visited);
        floodfill(r, c + 1, grid, rowLen, colLen, visited);
        floodfill(r, c + 1, grid, rowLen, colLen, visited);
        floodfill(r, c + 1, grid, rowLen, colLen, visited);
    }
}
