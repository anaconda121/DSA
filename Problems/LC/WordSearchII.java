class WordSearchII {
    int rowLen;
    int colLen;
    boolean[][] visited;
    HashSet<String> res;
    HashSet<Character> first;
    HashSet<String> prefixes;
    HashSet<String> w;

    void floodfill(int r, int c, char[][] grid, String currPath) {
        if (r < 0 || r >= rowLen || c < 0 || c >= colLen || visited[r][c]) return;

        currPath = new String(currPath + grid[r][c]);
        if (w.contains(currPath)) res.add(currPath);
        else if (!prefixes.contains(currPath)) return;
        visited[r][c] = true;

        floodfill(r, c + 1, grid, currPath);
        floodfill(r, c - 1, grid, currPath);
        floodfill(r + 1, c, grid, currPath);
        floodfill(r - 1, c, grid, currPath);

        visited[r][c] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        rowLen = board.length;
        colLen = board[0].length;
        visited = new boolean[rowLen][colLen];
        res = new HashSet<>();
        first = new HashSet<>();
        prefixes = new HashSet<>();
        w = new HashSet<>();

        for (String s : words) { 
            w.add(s);
            first.add(s.charAt(0));
            for (int i = 0; i < s.length(); i++) {
                prefixes.add(s.substring(0, i + 1));
            }
        }
        
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (first.contains(board[i][j])) {
                    floodfill(i, j, board, new String());
                }
            }
        }
        
        return new ArrayList<>(res);
    }
}
