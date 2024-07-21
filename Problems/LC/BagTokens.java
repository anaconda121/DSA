class BagTokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);

        int score = 0;
        int maxScore = 0;
        int currPower = power;
        int faceUpPtr = 0;
        int faceDownPtr = tokens.length - 1;

        while (faceUpPtr <= faceDownPtr) {
            if (currPower >= tokens[faceUpPtr]) {
                currPower -= tokens[faceUpPtr];
                score++;
                maxScore = Math.max(score, maxScore);
                faceUpPtr++;
            } else if (score >= 1) {
                currPower += tokens[faceDownPtr];
                score--;
                maxScore = Math.max(score, maxScore);
                faceDownPtr--;
            } else { break; }
        }

        return maxScore;
    }
}
