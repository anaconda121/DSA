class AverageWaitingTime {
    public double averageWaitingTime(int[][] customers) {
        int time = customers[0][0];
        double res = 0.0;
        for (int[] c : customers) {
            if (time < c[0]) {
                time = c[0];
            }
            time += c[1];
            res += (double) time - c[0];
        }
        return res / customers.length;
    }
}
