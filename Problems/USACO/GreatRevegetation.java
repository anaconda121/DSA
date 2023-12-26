// UNSOLVED

import java.util.*;
import java.io.*;

public class GreatRevegetation {

    static class FastIO extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar, numChars;

        // standard input
        public FastIO() { this(System.in, System.out); }
        public FastIO(InputStream i, OutputStream o) {
            super(o);
            stream = i;
        }
        // file input
        public FastIO(String i, String o) throws IOException {
            super(new FileWriter(o));
            stream = new FileInputStream(i);
        }

        // throws InputMismatchException() if previously detected end of file
        private int nextByte() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) { throw new InputMismatchException(); }
                if (numChars == -1) return -1;  // end of file
            }
            return buf[curChar++];
        }

        // to read in entire lines, replace c <= ' '
        // with a function that checks whether c is a line break
        public String next() {
            int c;
            do { c = nextByte(); } while (c <= ' ');
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = nextByte();
            } while (c > ' ');
            return res.toString();
        }
        public int nextInt() {  // nextLong() would be implemented similarly
            int c;
            do { c = nextByte(); } while (c <= ' ');
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = nextByte();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res = 10 * res + c - '0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }
        public double nextDouble() { return Double.parseDouble(next()); }
    }

    static class Pasture {
        int favoriteOne, favoriteTwo = 0;

        public Pasture(int f1, int f2) {
            favoriteOne = f1;
            favoriteTwo = f2;
        }
    }

    static int N, M, ans = 0;
    static boolean[] visited;
    static int[] colors;
    static HashMap<Pasture, String> farm = new HashMap<>();
    static List<Integer>[] adj;

    static void dfs(int i, int color) {
        if (visited[i]) return;

        colors[i] = color;
        visited[i] = true;
        for (int n: adj[i]) {
            if (farm.get(new Pasture(i, n)).equals("S")) {
                dfs(n, color);
            } else {
                if (color == 1) {
                    dfs(n, 2);
                }
                dfs(n, 1);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner io = new Scanner(new File("revegetate.in"));
        PrintWriter out = new PrintWriter(new File("revegetate.out"));

        N = io.nextInt();
        M = io.nextInt();
        visited = new boolean[N + 1];
        colors = new int[N + 1];
        adj = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) { adj[i] = new ArrayList<>(); }
        for (int i = 0; i < M; i++) {
            String condition = io.next();
            int f1 = Integer.parseInt(io.next());
            int f2 = Integer.parseInt(io.next());
            farm.put(new Pasture(f1, f2), condition);
            adj[f1].add(f2);
            adj[f2].add(f1);
        }

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                dfs(i, 1);
                dfs(i, 2);
            }
        }

        out.println(ans);
        out.println(Integer.toBinaryString(ans));
        out.close();
    }
}