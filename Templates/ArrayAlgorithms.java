import java.util.*;

class ArrayAlgorithms {

    /**
     * @param nums the input array of integers
     * @return an array where each element at index `i` is the sum of the elements
     * from the start of the input array up to index `i`
     */
    public static int[] createPrefixSum(int[] nums) {
        int[] prefixSum = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        return prefixSum;
    }

    /**
     * @param nums the array of integers
     * @param n the size of the sliding window
     */
    static void slidingWindowSizeN(int[] nums, int n) {
        int currSum = 0;
        int l = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (i >= n - 1) {
                // currSum = sum from index i - n + 1 to i at this line
                currSum -= nums[l];
                l++;
            }
        }
    }

    /**
     * @return list of integer arrays where the index represents the count 
     * of the value and the list at each index represents which 
     * numbers have that count
    */
    List<Integer>[] bucketSort(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap<>();

        for (int n : nums) {
            cnt.put(n, cnt.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] sorted = new List[nums.length + 1];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) { 
            sorted[e.getValue()].add(e.getKey());
        }

        return sorted;
    }

    boolean binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return true;
            else if (nums[m] > target) r = m - 1;
            else l = m + 1;
        }
        return false;
    }

    public List<Integer> insertSortedOrder(List<Integer> data, int num) {
        if (data.size() == 0) { data.add(num); return data; }
        if (num < data.get(0)) {data.add(0, num); return data; }

        int l = 0;
        int r = data.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (data.get(m) <= num) {
                if (m == data.size() - 1 || data.get(m + 1) >= num) {
                    data.add(m+1, num);
                    break;
                } else { l = m + 1; }
            } else if (data.get(m) > num) { r = m - 1; }
        }

        return data;
    }

}