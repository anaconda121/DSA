class FindWinningPlayerCoinGame {
    public String losingPlayer(int x, int y) {
        
        int playerNext = 0; // zero alice one bob

        while (x >= 1 && y >= 4) {
            x -= 1;
            y -= 4;
            if (playerNext == 0) playerNext = 1;
            else playerNext = 0; 
        }

        if (playerNext == 1) return "Alice";
        return "Bob";
    }
}
