class EvaluateDivision {
    class WeightedGraphNode {
        String dest;
        double weight;
        WeightedGraphNode(String d, double w) {
            dest = d;
            weight = w;
        }
    }

    HashMap<String, ArrayList<WeightedGraphNode>> adj = new HashMap<>();

    double bfs(String s, String t) {
        HashMap<String, Double> distance = new HashMap<>();
        for (String key : adj.keySet()) {
            distance.put(key, Double.MAX_VALUE);
        }
        distance.put(s, 1.0);
        
        PriorityQueue<WeightedGraphNode> q = new PriorityQueue<>((a, b) -> Double.compare(a.weight, b.weight));
        HashSet<String> visited = new HashSet<>();
        q.add(new WeightedGraphNode(s, 1.0));
        while (!q.isEmpty()) {
            WeightedGraphNode curr = q.poll();
            if (curr.dest.equals(t)) return distance.get(curr.dest);
            if (visited.contains(curr.dest)) continue;
            visited.add(curr.dest);
            
            for (WeightedGraphNode neighbor : adj.get(curr.dest)) {
                double newDist = distance.get(curr.dest) * neighbor.weight;
                if (newDist < distance.get(neighbor.dest)) {
                    distance.put(neighbor.dest, newDist);
                    q.add(new WeightedGraphNode(neighbor.dest, newDist));
                }
            }
        }

        return distance.get(t) == Double.MAX_VALUE ? -1 : distance.get(t);
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            List<String> e = equations.get(i);
            ArrayList<WeightedGraphNode> curr = adj.getOrDefault(e.get(0), new ArrayList<WeightedGraphNode>());
            curr.add(new WeightedGraphNode(e.get(1), values[i]));
            adj.put(e.get(0), curr);

            curr = adj.getOrDefault(e.get(1), new ArrayList<WeightedGraphNode>());
            curr.add(new WeightedGraphNode(e.get(0), 1.0 / values[i]));
            adj.put(e.get(1), curr);
        }

        double[] res = new double[queries.size()];
        int ptr = 0;
        for (List<String> q : queries) {
            if (!adj.containsKey(q.get(0)) || !adj.containsKey(q.get(1))) res[ptr] = -1.0;
            else res[ptr] = bfs(q.get(0), q.get(1));
            ptr++;
        }
        return res;
    }
}
