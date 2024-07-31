class MinimumCostConvertStringI {
    class Node {
        Character c;
        long w;
        Node(Character _c, long _w) {
            c = _c;
            w = _w;
        }
    }

    Map<Character, ArrayList<Node>> adj = new HashMap<>();
    Map<String, Long> memo = new HashMap<>();

    long dijkstra(char s, char t) {
        String key = s + "->" + t;
        if (memo.containsKey(key)) return memo.get(key);

        long[] distance = new long[26];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[s - 'a'] = 0;

        PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> Long.compare(a.w, b.w));
        boolean[] visited = new boolean[26];
        q.add(new Node(s, 0));
        
        while (!q.isEmpty()) {
            Node n = q.poll();
            if (n.c == t) break;
            if (visited[n.c - 'a']) continue;
            visited[n.c - 'a'] = true;
            
            for (Node neighbor : adj.get(n.c)) {
                if (distance[n.c - 'a'] + neighbor.w < distance[neighbor.c - 'a']) {
                    distance[neighbor.c - 'a'] = distance[n.c - 'a'] + neighbor.w;
                    q.add(new Node(neighbor.c, distance[neighbor.c - 'a']));
                }
            }
        }

        long result = distance[t - 'a'];
        memo.put(key, result);
        return result;
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        for (char a = 'a'; a <= 'z'; a++) { adj.put(a, new ArrayList<>()); }

        for (int i = 0; i < original.length; i++) {
            adj.get(original[i]).add(new Node(changed[i], (long) cost[i]));
        }

        long res = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                long changeCost = dijkstra(source.charAt(i), target.charAt(i));
                if (changeCost == Long.MAX_VALUE) return -1;
                res += changeCost;
            }
        }

        return res;
    }
}
