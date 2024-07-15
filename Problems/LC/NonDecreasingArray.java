class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;

        int[] scenario1 = Arrays.copyOf(nums, n);
        int[] scenario2 = Arrays.copyOf(nums, n);

        int changesScenario1 = 0;
        int changesScenario2 = 0;

        for (int i = 0; i < n - 1; i++) {
            if (scenario1[i] > scenario1[i + 1]) {
                scenario1[i] = scenario1[i + 1];
                changesScenario1++;
            }

            if (scenario2[i] > scenario2[i + 1]) {
                scenario2[i + 1] = scenario2[i];
                changesScenario2++;
            }
        }

        boolean isNonDecreasingScenario1 = true;
        boolean isNonDecreasingScenario2 = true;

        for (int i = 1; i < n; i++) {
            if (scenario1[i] < scenario1[i - 1]) {
                isNonDecreasingScenario1 = false;
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            if (scenario2[i] < scenario2[i - 1]) {
                isNonDecreasingScenario2 = false;
                break;
            }
        }

        boolean result = (isNonDecreasingScenario1 && changesScenario1 <= 1) ||
                         (isNonDecreasingScenario2 && changesScenario2 <= 1);

        return result;
    }
}
