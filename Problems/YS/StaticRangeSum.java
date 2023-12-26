// https://judge.yosupo.jp/problem/static_range_sum

import java.util.*;

class StaticRangeSum {

    static int N, Q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        Q = sc.nextInt();

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }

        long[] prefix = new long[N + 1];
        for (int i = 0; i < N; i++) {
            prefix[i + 1] = arr[i] + prefix[i];
        }

        for (int i = 0; i < Q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            System.out.println(prefix[r] - prefix[l]);
        }
    }

}