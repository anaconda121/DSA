#include <bits/stdc++.h>

using namespace std;

int N, T, ans = INT_MAX;
vector<int> arr;

void setIO(string name, bool includeout=false) {
    ios_base::sync_with_stdio(0); cin.tie(0);
    freopen((name+".in").c_str(), "r", stdin);
    if (includeout) {
        freopen((name+".out").c_str(), "w", stdout);
    }
}

int f(int k) {
    vector<int> tmp = arr;
    int finished = 0;
    int currTime = 0;
    
    while (finished < N) {
        int overflowCounter = 0;
        currTime += tmp[finished];
        if (N - finished < k) {
            for (int i = 1; i < N - finished; i++) {
                tmp[finished + i] -= tmp[finished];
            }
        } else {
            for (int i = 1; i < k; i++) {
                tmp[finished + i] -= tmp[finished];
                if (tmp[finished + i] < 0) {
                    int leakage = tmp[finished + i];
                    tmp[finished + i] = 0;
                    tmp[finished + k + overflowCounter] += leakage;
                    overflowCounter++;
                }
            }
        }
        finished++;
    }

    // cout << currTime << " " << k << "\n";

    return currTime <= T;
}

int binarySearch(int lo, int hi) {
    while (lo <= hi) {
        int mid = lo + (hi - lo + 1) / 2;
        // cout << mid << "\n";
        if (f(mid)) {
            ans = min(ans, mid);
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }
    return lo;
}

int main() {
    setIO("cowdance", true);
    cin >> N >> T;
    
    for (int i = 0; i < N; i++) {
        int a; cin >> a;
        arr.push_back(a);
    }
    // sort(arr.begin(), arr.end());

    binarySearch(1, N);
    cout << ans << "\n";

    return 0;
}