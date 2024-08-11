import java.util.*;

public class GraphAlgorithms {

    class WeightedGraphNode {
        int dest;
        int weight;
        WeightedGraphNode(int d, int w) {
            dest = d;
            weight = w;
        }
    }

    void floodfill(int r, int c, int[][] grid, int rowLen, int colLen, boolean[][] visited) {
        if (r < 0 || r >= rowLen || c < 0 || c >= colLen || visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        floodfill(r, c + 1, grid, rowLen, colLen, visited);
        floodfill(r, c - 1, grid, rowLen, colLen, visited);
        floodfill(r + 1, c, grid, rowLen, colLen, visited);
        floodfill(r - 1, c, grid, rowLen, colLen, visited);
    }

    int bfsFloodfill(int[][] grid, int[] s, int[] t) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];

        // arrays for 8-directional search; can modify for 4-directional
        int[] xDir = new int[]{1, 1, 1, 0, 0, -1, -1, -1};
        int[] yDir = new int[]{1, 0, -1, 1, -1, 1, 0, -1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{s[0], s[1], 0}); // (r, c, distance)
        visited[s[0]][s[1]] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];

            if (r == t[0] && c == t[0]) { return d + 1; }

            for (int i = 0; i < xDir.length; i++) {
                int newRow = r + xDir[i];
                int newCol = c + yDir[i];
                if (newRow >= 0 && newRow < rowLen
                        && newCol >= 0 && newCol < colLen
                        && !visited[newRow][newCol] && grid[newRow][newCol] == 0) {
                    q.add(new int[]{newRow, newCol, d + 1});
                    visited[newRow][newCol] = true;
                }
            }
        }

        return -1; // path does not exist
    }

    void dijkstra(int s, HashMap<Integer, ArrayList<WeightedGraphNode>> adj) {
        int[] distance = new int[adj.keySet().size()];
        Arrays.fill(distance , Integer.MAX_VALUE);
        distance[s] = 0;

        PriorityQueue<WeightedGraphNode> q = new PriorityQueue<>((a, b) -> (Integer.compare(a.weight, b.weight)));
        boolean[] visited = new boolean[distance.length];
        q.add(new WeightedGraphNode(s, 0));
        while (!q.isEmpty()) {
            int curr = q.poll().dest;
            // want shortest path from s to some target t, check `if (curr == t) break;`
            if (visited[curr]) continue;
            visited[curr] = true;

            for (WeightedGraphNode n : adj.get(curr)) {
                int distDest = distance[curr] + n.weight;
                if (distDest < distance[n.dest]) {
                    distance[n.dest] = distDest;
                    q.add(new WeightedGraphNode(n.dest, distDest));
                }
            }
        }
    }

    void dfsTopologicalSort(int n, boolean[] isCycle, boolean[] visited, boolean[] path, HashMap<Integer, ArrayList<Integer>> adj, ArrayList<Integer> res) {
        if (visited[n]) return;
        if (path[n]) {
            isCycle[0] = true;
            return;
        }

        visited[n] = true;
        path[n] = true;
        for (int neighbor : adj.get(n)) {
            dfsTopologicalSort(neighbor, isCycle, visited, path, adj, res);
        }
        path[n] = false;
        res.add(n);
    }

    ArrayList<Integer> topologicalSort(HashMap<Integer, ArrayList<Integer>> adj, boolean[] visited) {
        boolean[] isCycle = new boolean[1];
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                dfsTopologicalSort(i, isCycle, new boolean[adj.size()], new boolean[adj.size()], adj, res);
            }
        }

        if (isCycle[0]) {
            return (ArrayList) Collections.emptyList();
        }

        Collections.reverse(res);
        return res;
    }
}
