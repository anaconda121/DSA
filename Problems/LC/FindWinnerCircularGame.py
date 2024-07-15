class FindWinnerCircularGame:
    def findTheWinner(self, n: int, k: int) -> int:
        players = [i for i in range(1, n + 1)]

        start_idx = 0
        while len(players) > 1:
            loser = (start_idx + k - 1) % len(players)
            del players[loser]
            start_idx = (loser) % len(players)
            
        return players[0]
