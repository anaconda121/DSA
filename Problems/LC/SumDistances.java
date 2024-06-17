class SumDistances {
    public long[] distance(int[] nums) {
        long[] arr = new long[nums.length];
        HashMap<Integer, ArrayList<Integer>> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            indexMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (Map.Entry<Integer, ArrayList<Integer>> entry : indexMap.entrySet()) {
            ArrayList<Integer> indices = entry.getValue();

            long[] prefixSums = new long[indices.size()];
            prefixSums[0] = indices.get(0);
            for (int i = 1; i < indices.size(); i++) {
                prefixSums[i] = prefixSums[i - 1] + indices.get(i);
            }

            for (int i = 0; i < indices.size(); i++) {
                long totalSum = 0;
                int idx = indices.get(i);

                // to the left
                if (i > 0) {
                    totalSum += (long) i * idx - prefixSums[i - 1];
                }

                // to the right
                if (i < indices.size() - 1) {
                    totalSum += (prefixSums[indices.size() - 1] - prefixSums[i]) - (long) (indices.size() - 1 - i) * idx;
                }

                arr[idx] = totalSum;
            }
        }

        return arr;
    }
}
