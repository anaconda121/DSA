// https://cses.fi/problemset/task/1074/

import java.util.*;

public class StickLengths {

    static int N = 0;
    static long avg, count, proposedLen = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        long[] sticks = new long[N];

        for (int i = 0; i < N; i++) {
            sticks[i] = sc.nextLong();
            avg += sticks[i];
        }

        Arrays.sort(sticks);

        proposedLen = sticks[sticks.length / 2];

        for (int i = 0; i < N; i++) {
            count += Math.abs(sticks[i] - proposedLen);
        }

        System.out.println(count);
    }

}
