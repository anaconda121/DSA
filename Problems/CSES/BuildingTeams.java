// https://cses.fi/problemset/task/1668/

import java.io.*;
import java.util.*;

public class BuildingTeams {

    static int N, M = 0;
    static boolean[] visited;
    static int[] colors;
    static List<Integer>[] adj;

    static String impossible = "";

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

    static void dfs(int i, int color) {
        if (visited[i]) return;

        colors[i] = color;
        visited[i] = true;
        for (int n: adj[i]) {
            if (colors[n] == colors[i] && visited[n]) impossible = "IMPOSSIBLE";
            if (color == 1) {
                dfs(n, 2);
            }
            dfs(n, 1);
        }
    }

    public static void main(String[] args) {
        FastIO io = new FastIO();
        N = io.nextInt();
        M = io.nextInt();

        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        colors = new int[N + 1];

        for (int i = 1; i < N + 1; i++) { adj[i] = new ArrayList<>(); }

        for (int i = 0; i < M; i++) {
            int a = io.nextInt();
            int b = io.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                dfs(i, 1);
            }
        }

        if (!impossible.equals("")) {
            System.out.println(impossible);
        } else {
            for (int i = 1; i < N + 1; i++) {
                System.out.print(colors[i] + " ");
            }
        }
    }

}
