// https://codeforces.com/gym/102951/problem/B

import java.io.*;
import java.util.*;

public class StudyingAlgorithms {

    static int N, X;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        X = sc.nextInt();

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);

        long totalMins = 0;
        int ans = 0;
        while (ans < N && totalMins + arr[ans] <= X) {
            totalMins += arr[ans];
            ans++;
        }

        System.out.println(ans);
    }
}
