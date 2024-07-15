class PassPillow {
    public int passThePillow(int n, int time) {
        int rounds = time / (n - 1);
        if (rounds % 2 == 1) {
            return n - (time % (n - 1));
        } else {
            return 1 + (time % (n - 1));
        }
    }
}
