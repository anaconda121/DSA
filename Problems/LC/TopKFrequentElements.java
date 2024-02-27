import java.util.*;

class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        int[] ans = new int[k];

        for (int i = 0; i < nums.length; i++) {
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
        }

        Map<Integer, Integer> sortedMap = counts.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey, 
                        Map.Entry::getValue, 
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        List<Integer> frequentVals = new ArrayList<>(sortedMap.keySet());

        for (int i = 0; i < k; i++) {
            ans[i] = frequentVals.get(i);
        }

        return ans;
    }
}
