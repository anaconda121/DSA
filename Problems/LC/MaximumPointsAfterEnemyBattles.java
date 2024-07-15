class MaximumPointsAfterEnemyBattles {
    public static long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        Arrays.sort(enemyEnergies);

        int smallestUnmarkedIdx = 0;
        int largestUnmarkedIdx = enemyEnergies.length - 1;
        long points = 0;
        long currentEnergyLong = currentEnergy;
        
        if (enemyEnergies[0] > currentEnergy) return 0;
        
        while (smallestUnmarkedIdx <= largestUnmarkedIdx) {
            if (currentEnergyLong >= enemyEnergies[smallestUnmarkedIdx]) {
                points += currentEnergyLong / enemyEnergies[smallestUnmarkedIdx];
                currentEnergyLong %= enemyEnergies[smallestUnmarkedIdx];
            } else if (points > 0) {
                currentEnergyLong += enemyEnergies[largestUnmarkedIdx];
                largestUnmarkedIdx--;
            } else {
                break;
            }
        }

        return points;
    }
}
