#include <bits/stdc++.h>

using namespace std;

#define ll long long

vector<ll> arr, psum, prevArr;
ll N, X, l, r, ans = 0;

void setIO(string name, bool includeout=false) {
    ios_base::sync_with_stdio(0); cin.tie(0);
    freopen((name+".in").c_str(), "r", stdin);
    if (includeout) {
        freopen((name+".out").c_str(), "w", stdout);
    }
}

int main() {
    setIO("input", false);
    cin >> N >> X;
    for (int i = 0; i < N; i++) {
        int a; cin >> a;
        arr.push_back(a);
    }
    for (int i: arr) {cout << i << " ";} cout << "\n";

    psum.push_back(0);
    for (int i = 1; i < N + 1; i++) {
        prevArr.push_back(psum[i - 1] + arr[i - 1]);
        psum.push_back(psum[i - 1] + arr[i - 1]);
    }
    // sort(psum.begin(), psum.end());

    for (int i: psum) {cout << i << " ";} cout << "\n";

    l = 1; r = 2;
    while (l < N) {
        cout << l << " " << r << " " << psum[r] - psum[l - 1] << "\n";
        if (psum[r] - psum[l - 1] > X) {
            l++;
        } else if (psum[r] - psum[l - 1] == X) {
            if (arr[l] < 0) {
                // removing it increases subarray val
                l++;
            } else {
                // removing it decreases subarray val

            }
            ans++;
        } else {
            r--;
        }
    }

    cout << ans << "\n";
}