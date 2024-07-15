class WordSearch {
    int rowLen;
    int colLen;
    boolean[][] visited;

    boolean floodfill(int r, int c, char[][] grid, int index, String word) {
        if (r < 0 || r >= rowLen || c < 0 || c >= colLen || visited[r][c] || grid[r][c] != word.charAt(index)) {
            return false;
        }
        
        if (index == word.length() - 1) {
            return true;
        }
        
        visited[r][c] = true;

        boolean found =  floodfill(r, c + 1, grid, index + 1, word) ||
                        floodfill(r, c - 1, grid, index + 1, word) ||
                        floodfill(r + 1, c, grid, index + 1, word) ||
                        floodfill(r - 1, c, grid, index + 1, word);

        visited[r][c] = false;
        return found;
    }

    public boolean exist(char[][] board, String word) {
        rowLen = board.length;
        colLen = board[0].length;
        visited = new boolean[rowLen][colLen];

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (floodfill(i, j, board, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }
}
