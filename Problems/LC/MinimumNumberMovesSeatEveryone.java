class MinimumNumberMovesSeatEveryone {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int cost = 0;
        for (int i = 0; i < seats.length; i++) {
            cost += Math.abs(seats[i] - students[i]);
        }
        return cost;
    }
}
