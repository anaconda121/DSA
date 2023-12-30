//https://codeforces.com/contest/1201/problem/C 

#include <bits/stdc++.h>

using namespace std;

int N, K, medIdx, endIdx;
vector<int> arr;    

bool f(int m) {
    int operationCount = 0;
    for (int i = medIdx; i <= endIdx; i++) {
        if (arr[i] < m) {
            operationCount += m - arr[i];
        }
    }
    return operationCount <= K;
}

int binarySearch(int lo, int hi) {
    while (lo < hi) {
        int mid = lo + (hi - lo + 1) / 2;
        if (f(mid)) {
            lo = mid;
        } else {
            hi = mid - 1;
        }
    }
    return lo;
}

int main() {
    cin >> N >> K;
    
    for (int i = 0; i < N; i++) {
        int a; cin >> a;
        arr.push_back(a);
    }

    sort(arr.begin(), arr.end());

    medIdx = arr.size() / 2;
    endIdx = arr.size() - 1;

    cout << binarySearch(arr[medIdx], arr[endIdx] + K) << "\n";
    return 0;
}