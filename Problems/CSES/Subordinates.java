import java.io.*;
import java.util.*;

public class Subordinates {

    static int N;
    static ArrayList<Integer>[] adj;
    static int[] count;

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

    static void dfs(int i, int p) {
        // p -> parent
        count[i] = 1;
        for (int n: adj[i]) {
            if (n == p) continue;
            dfs(n, i);
            count[i] += count[n];
        }
    }

    public static void main(String[] args) {
        FastIO io = new FastIO();
        N = io.nextInt();
        adj = new ArrayList[N + 1];
        count = new int[N + 1];

        for (int i = 0; i < N + 1; i++) { adj[i] = new ArrayList<>(); }
        for (int i = 2; i < N + 1; i++) {
            int boss = io.nextInt();
            adj[boss].add(i);
//            adj[i].add(boss);
        }

//        for (ArrayList<Integer> a: adj) {
//            System.out.println(Arrays.toString(a.toArray()));
//        }

        dfs(1, 0);

        for (int i = 1; i < count.length; i++) {
            System.out.print(count[i] - 1 + " ");
        }
    }

}
