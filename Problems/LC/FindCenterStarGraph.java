public class FindCenterStarGraph {
    public static int findCenter(int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new HashSet<>());
            graph.putIfAbsent(edge[1], new HashSet<>());
            
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

       for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == graph.size() - 1) {
                return entry.getKey();
            }
        }

        return -1;   
    }
}
