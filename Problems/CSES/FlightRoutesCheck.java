// UNSOLVED

import java.io.*;
import java.util.*;

public class FlightRoutesCheck {

    static int N, M, visitedCount, fullyConnectedNode, cantVisit1, cantVisit2 = 0;
    static boolean[] visited;
    static boolean foundTarget = false;
    static ArrayList<Integer>[] adj;

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

    static void dfs(int i) {
        if (visited[i]) return;

        visited[i] = true;
        visitedCount++;
        if (visitedCount == N + 1) return;
        for (int n: adj[i]) {
            dfs(n);
        }
    }

    public static void main(String[] args) {
        FastIO io = new FastIO();

        N = io.nextInt();
        M = io.nextInt();
        visited = new boolean[N + 1];
        adj = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) { adj[i] = new ArrayList<>(); }

        for (int i = 0; i < M; i++) {
            int a = io.nextInt();
            int b = io.nextInt();
            adj[a].add(b);
        }

        for (int i = 1; i < N + 1; i++) {
            visitedCount = 1;
            visited = new boolean[N + 1];
            dfs(i);
            if (visitedCount == N + 1) {
                fullyConnectedNode = i;
                break;
            }
        }

//        System.out.println(fullyConnectedNode);

        for (int i = 1; i < N + 1; i++) {
            if (i != fullyConnectedNode && adj[i].size() == 0) {
                cantVisit1 = i;
                cantVisit2 = fullyConnectedNode;
            }
        }

        if (cantVisit1 == 0 && cantVisit2 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
            System.out.println(cantVisit1 + " " + cantVisit2);
        }
    }
}
