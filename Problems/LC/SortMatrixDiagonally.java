class SortMatrixDiagonally {
    void getAndSort(int[][] mat, int startPtr, int rowPtr, int colPtr, boolean rowWise) {
        ArrayList<Integer> vals = new ArrayList<>();
        while (rowPtr < mat.length && colPtr < mat[0].length) {
            vals.add(mat[rowPtr][colPtr]);
            rowPtr++; colPtr++;
        }
        Collections.sort(vals);
        if (rowWise) {
        rowPtr = 0;
        colPtr = startPtr;
        } else {
            rowPtr = startPtr;
            colPtr = 0;
        }
        int valPtr = 0;
        while (valPtr < vals.size()) {
            mat[rowPtr][colPtr] = vals.get(valPtr);
            valPtr++; rowPtr++; colPtr++;
        }
    }

    public int[][] diagonalSort(int[][] mat) {
        
        int startPtr = mat[0].length - 1;
        while (startPtr >= 0) {
            getAndSort(mat, startPtr, 0, startPtr, true);
            startPtr--;
        }
        
        startPtr = 1;
        while (startPtr < mat.length) {
            getAndSort(mat, startPtr, startPtr, 0, false);
            startPtr++;
        }
        
        return mat;
    }
}
