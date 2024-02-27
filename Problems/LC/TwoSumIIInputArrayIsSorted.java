class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        int[] ans = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            int currSum = numbers[l] + numbers[r];
            if (currSum == target) {
                ans[0] = l + 1;
                ans[1] = r + 1;
            } else if (currSum > target) {
                r--;
            } else {
                l++;
            }
        }

        return ans;
    }
}
