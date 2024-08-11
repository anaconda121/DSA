class CountSeniors:
    def countSeniors(self, details: List[str]) -> int:
        cnt = 0
        for i in range(len(details)):
            if (int(details[i][11:13]) > 60): cnt += 1
        return cnt
