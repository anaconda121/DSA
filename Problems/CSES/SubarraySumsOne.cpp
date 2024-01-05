// https://cses.fi/problemset/task/1660/

#include <bits/stdc++.h>

using namespace std;

#define ll long long

vector<ll> arr, psum;
ll N, X, l, r, ans, currSum = 0;

void setIO(string name, bool includeout=false) {
    ios_base::sync_with_stdio(0); cin.tie(0);
    freopen((name+".in").c_str(), "r", stdin);
    if (includeout) {
        freopen((name+".out").c_str(), "w", stdout);
    }
}

int main() {
    // setIO("input", false);
    cin >> N >> X;
    for (int i = 0; i < N; i++) { int a; cin >> a; arr.push_back(a); }

    psum.push_back(0);
    for (int i = 1; i < N + 1; i++) {
        psum.push_back(psum[i - 1] + arr[i - 1]);
    }

    l = 1; r = 1;
    while (l < N + 1 && r < N + 1) {
        currSum = psum[r] - psum[l - 1];
        if (currSum < X) { r++; }
        else if (currSum > X) { l++; } 
        else {
            ans++;
            r++;
        }
    }

    cout << ans << "\n";

    return 0;
}