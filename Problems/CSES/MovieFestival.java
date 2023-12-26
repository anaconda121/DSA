// https://cses.fi/problemset/task/1629/

import java.io.*;
import java.util.*;

public class MovieFestival {

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


    static class Interval implements Comparable<Interval> {
        int start, end;

        public Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public int compareTo(Interval o) {
            if (end != o.end) {
                return Integer.compare(end, o.end);
            }
            return Integer.compare(end - start, o.end - o.start);
        }
    }

    static Interval[] l;
    static int N;

    public static void main(String[] args) {
        FastIO sc = new FastIO();
        N = sc.nextInt();
        l = new Interval[N];

        for (int i = 0; i < N; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            l[i] = (new Interval(s, e));
        }

        Arrays.sort(l);

//        for (Interval i : l) {
//            System.out.println(i.start + " " + i.end);
//        }

        int ans = 0;
        long endingOfLastMovie = -1;
        for (int i = 0; i < N; i++) {
            if (endingOfLastMovie <= l[i].end &&l[i].start >= endingOfLastMovie) {
                endingOfLastMovie = l[i].end;
                ans++;
            }
        }

        System.out.println(ans);
    }

}
