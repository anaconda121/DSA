class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] numsS = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsS);

        int l = 0;
        int r = numsS.length - 1;
        while (l < r) {
            int sum = numsS[l] + numsS[r];
            if (sum == target) break;
            else if (sum > target) r--;
            else l++;
        }

        int[] res = new int[2];
        boolean foundFirst = false;
        boolean foundSecond = false;
        for (int i = 0; i < nums.length; i++) {
            if (!foundFirst && numsS[l] == nums[i]) {
                res[0] = i;
                foundFirst = true;
            } else if (!foundSecond && numsS[r] == nums[i]) {
                res[1] = i;
                foundSecond = true;
            }
        }
        return res;
    }
}
