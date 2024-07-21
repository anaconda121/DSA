class SetMatrixZeroes {
    void setRowZero(int[][] matrix, int i) {
        for (int x = 0; x < matrix[0].length; x++) {
            matrix[i][x] = 0;
        }
    }

    void setColZero(int[][] matrix, int j) {
        for (int x = 0; x < matrix.length; x++) {
            matrix[x][j] = 0;
        }
    }
    
    public void setZeroes(int[][] matrix) {
        List<int[]> pos = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    pos.add(new int[]{i, j});
                }
            }
        }

        for (int[] p : pos) {
            setRowZero(matrix, p[0]);
            setColZero(matrix, p[1]);
        }
    }
}
