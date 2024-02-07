#include <bits/stdc++.h>

using namespace std;

#define ll long long

vector<ll> arr, psum, prevArr;
ll N, l, r, ans = 0;

void setIO(string name, bool includeout=false) {
    ios_base::sync_with_stdio(0); cin.tie(0);
    freopen((name+".in").c_str(), "r", stdin);
    if (includeout) {
        freopen((name+".out").c_str(), "w", stdout);
    }
}

int main() {
    setIO("input", false);
    cin >> N;
    for (int i = 0; i < N; i++) {
        int x; cin >> x;
        arr.push_back(x);
    }
    for (int i: arr) {cout << i << " ";} cout << "\n";

    psum.push_back(0);
    for (int i = 1; i < N + 1; i++) {
        psum.push_back(psum[i - 1] + arr[i - 1]);
    }
    // for (int i: psum) {cout << i << " ";} cout << "\n";

    l = 0; r = 1;
    ll currSum = arr[r] + arr[l];
    if (currSum % 7 == 0 && currSum >= 7) {
        ans = max(ans, r - l);
    }

    cout << currSum << "\n";

    while (l < N && r < N) {
        currSum -= arr[l];
        l++;
        
        while ((currSum < 7 || currSum % 7 != 0) && r < N - 1) {
            currSum += arr[r + 1];
            r++;
        }

        if (currSum % 7 == 0 && currSum >= 7) {
            ans = max(ans, r - l + 1);
        }

        cout << r << " " << l << " " << currSum << " " << ans << "\n";
    }

    cout << ans << "\n";

    return 0;
}