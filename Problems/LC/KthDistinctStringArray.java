class KthDistinctStringArray {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> countMap = new HashMap<>();
        
        for (String s : arr) {
            countMap.put(s, countMap.getOrDefault(s, 0) + 1);
        }
        
        List<String> distinctStrings = new ArrayList<>();
        
        for (String s : arr) {
            if (countMap.get(s) == 1) {
                distinctStrings.add(s);
            }
        }
        
        if (distinctStrings.size() < k) {
            return "";
        }
        
        return distinctStrings.get(k - 1);
    }
}
