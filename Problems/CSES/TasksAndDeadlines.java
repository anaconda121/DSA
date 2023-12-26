// https://cses.fi/problemset/task/1630/

import java.io.*;
import java.util.*;

public class TasksAndDeadlines {

    static class Task implements Comparable<Task> {
        int deadline, duration;

        public Task(int d, int du) {
            duration = d;
            deadline = du;
        }

        @Override
        public int compareTo(Task o) {
            return Integer.compare(duration, o.duration);
        }
    }

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

    static int N = 0;
    static long reward, currTime = 0;
    static Task[] t;

    public static void main(String[] args) {
        FastIO sc = new FastIO();
        N = sc.nextInt();
        t = new Task[N];

        for (int i = 0; i < N; i++) {
            t[i] = new Task(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(t);

        for (int i = 0; i < N; i++) {
            currTime += t[i].duration;
            reward += t[i].deadline - currTime;
        }

        System.out.println(reward);

    }

}
