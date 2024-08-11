class FarFromLandPossible {
    public int maxDistance(int[][] grid) {
        ArrayList<int[]> land = new ArrayList<int[]>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    land.add(new int[]{i, j});
                }
            }
        }

        if (land.size() == 0 || land.size() == grid.length * grid[0].length) return -1;

        int res = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int maxdist = Integer.MAX_VALUE;
                if (grid[i][j] == 0) {
                    for (int k = 0; k < land.size(); k++) {
                        maxdist = Math.min(maxdist, Math.abs(i - land.get(k)[0]) + Math.abs(j - land.get(k)[1]));
                    }
                    res = Math.max(res, maxdist);
                }
                
            }
        }
        return res;
    }
}
