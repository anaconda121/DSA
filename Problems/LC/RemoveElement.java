class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        int backPtr = nums.length - 1;
        while (backPtr > 0 && nums[backPtr] == val) backPtr--;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) k++;
        }
        
        for (int i = 0; i < nums.length - k; i++) {
            if (nums[i] == val && backPtr > 0) {
                int tmp = nums[backPtr];
                nums[backPtr] = nums[i];
                nums[i] = tmp;
            }
            while (backPtr > 0 && nums[backPtr] == val) backPtr--;
        }

        return nums.length - k;
    }
}
