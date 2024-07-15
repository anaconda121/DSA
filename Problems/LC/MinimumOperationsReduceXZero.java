class MinimumOperationsReduceXZero {
    public int minOperations(int[] nums, int x) {
        HashMap<Integer, Integer> front = new HashMap<>();
        HashMap<Integer, Integer> back = new HashMap<>();

        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            front.put(currSum, i + 1);
        }

        if (currSum < x) return -1;
        else if (currSum == x) return nums.length;

        currSum = 0;
        int ctr = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            currSum += nums[i];
            back.put(currSum, ctr);
            ctr++;
        }

        int res = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> e : front.entrySet()) {
            int goal = x - e.getKey();
            if (back.containsKey(goal)) {
                res = Math.min(res, e.getValue() + back.get(goal));
            } else if (goal == 0) res = Math.min(res, e.getValue());
        }

        for (Map.Entry<Integer, Integer> e : back.entrySet()) {
            int goal = x - e.getKey();
            if (front.containsKey(goal)) {
                res = Math.min(res, e.getValue() + front.get(goal));
            } else if (goal == 0) res = Math.min(res, e.getValue());
        }

        if (res == Integer.MAX_VALUE) return -1;
        return res;
    }
}
