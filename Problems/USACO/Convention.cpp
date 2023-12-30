#include <bits/stdc++.h>

using namespace std;

int N, M, C, ans = INT_MAX;
vector<int> arr;

void setIO(string name, bool includeout=false) {
    ios_base::sync_with_stdio(0); cin.tie(0);
    freopen((name+".in").c_str(), "r", stdin);
    if (includeout) {
        freopen((name+".out").c_str(), "w", stdout);
    }
}

int f(int wait) {
    int maxWait = 0;
    for (int i = 0; i < arr.size(); i += C) {
        int currWait = arr[i + C - 1] - arr[i];
        maxWait = max(maxWait, currWait);
    }
    return wait <= maxWait && wait <= ans;
}

int binarySearch(int lo, int hi) {
    while (lo < hi) {
        int mid = lo + (hi - lo + 1) / 2;
        cout << mid << " " << f(mid) << "\n";
        if (f(mid)) {
            ans = min(ans, mid);
            lo = mid;
        } else {
            hi = mid - 1;
        }
    }
    return lo;
}

int main() {
    setIO("input", false);
    cin >> N >> M >> C;
    
    for (int i = 0; i < N; i++) {
        int a; cin >> a;
        arr.push_back(a);
    }
    sort(arr.begin(), arr.end());

    binarySearch(0, arr[arr.size() - 1] - arr[0]);
    cout << ans << "\n";

    return 0;
}