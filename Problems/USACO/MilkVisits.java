import java.util.*;
import java.io.*;

public class MilkVisits {

    static int N, M = 0;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static HashMap<Integer, Character> farms;
    static boolean happy, foundEnd = false;
    static String ans = "";

    static void dfs(int i, int end, char pref) {
        if (visited[i]) return;
        visited[i] = true;

        System.out.println(i + " " + end + " " + farms.get(i) + " " + pref);

        if (farms.get(i) == pref) {
            happy = true;
            return;
        }
        if (i == end) { foundEnd = true; return; }

        if (adj[i].contains(end)) {
            foundEnd = true;
            dfs(end, end, pref);
        } else {
            for (int n : adj[i]) {
                if (!foundEnd) {
                    dfs(n, end, pref);
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner io = new Scanner(new File("milkvisits.in"));
        PrintWriter out = new PrintWriter(new File("milkvisits.out"));
        N = io.nextInt();
        M = io.nextInt();
        String cowTypes = io.next();

        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        farms = new HashMap<>();

        for (int i = 0; i < N + 1; i++) { adj[i] = new ArrayList<>(); }

        for (int i = 0; i < cowTypes.length(); i++) {
            farms.put(i + 1, cowTypes.charAt(i));
        }

        for (int i = 1; i < N; i++) {
            int start, end;
            start = io.nextInt();
            end = io.nextInt();
            adj[start].add(end);
            adj[end].add(start);
        }

        for (int i = 0; i < M; i++) {
            visited = new boolean[N + 1];
            happy = false;
            foundEnd = false;
            int start = Integer.parseInt(io.next());
            int end = Integer.parseInt(io.next());
            char pref = io.next().charAt(0);
//            System.out.println(start + " " + end + " " + pref);
            dfs(start, end, pref);
            System.out.println("------");
            if (happy) {
                ans += "1";
            } else {
                ans += "0";
            }
        }

        out.println(ans);
        out.close();
    }

}
