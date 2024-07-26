class LuckyNumbersMatrix {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> rowMins = new HashSet<>();
        HashSet<Integer> colMaxs = new HashSet<>();

        // find rowMins
        for (int i = 0; i < matrix.length; i++) {
            int rowMin = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[0].length; j++) {
                rowMin = Math.min(rowMin, matrix[i][j]);
            }
            rowMins.add(rowMin);
        } 

        // find colMaxs 
        for (int i = 0; i < matrix[0].length; i++) {
            int colMax = Integer.MIN_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                colMax = Math.max(colMax, matrix[j][i]);
            }
            colMaxs.add(colMax);
        }

        for (int i : rowMins) {
            if (colMaxs.contains(i)) res.add(i);
        }

        return res;
    }
}
