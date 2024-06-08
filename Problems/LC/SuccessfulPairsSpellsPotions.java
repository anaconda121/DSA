public class SuccessfulPairsSpellsPotions {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            int l = 0;
            int r = potions.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                long strength = (long) spells[i] * potions[mid];
                if (strength >= success) {
                    ans[i] = potions.length - mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return ans;
    }
}
