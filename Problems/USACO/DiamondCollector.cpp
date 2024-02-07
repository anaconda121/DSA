#include <bits/stdc++.h>

using namespace std;

#define ll long long

vector<ll> diamonds, diamondsTwo;
ll N, K, ansOne, oneStart, oneEnd, ansTwo, twoStart, twoEnd = LLONG_MIN;

void setIO(string name, bool includeout=false) {
    ios_base::sync_with_stdio(0); cin.tie(0);
    freopen((name+".in").c_str(), "r", stdin);
    if (includeout) {
        freopen((name+".out").c_str(), "w", stdout);
    }
}

int main() {
    setIO("diamond", true);
    cin >> N >> K;
    for (int i = 0; i < N; i++) {
        int a; cin >> a;
        diamonds.push_back(a);
    }
    sort(diamonds.begin(), diamonds.end());

    ll l = 0; ll r = 1;
    while (l < N && r < N) {
        
        ll diff = abs(diamonds[r] - diamonds[l]);
        while (diff <= K) {
            r++;
            diff = abs(diamonds[r] - diamonds[l]); 
        }

        if (r - l > ansOne) {
            ansOne = r - l;
            oneStart = l; oneEnd = r;
        }
        // cout << r << " " << l << "\n";
        l++;
    }

    diamonds.erase(diamonds.begin() + oneStart, diamonds.begin() + oneEnd);
    diamondsTwo = diamonds;

    // for (int i: diamondsTwo) {cout << i << " ";} cout << "\n";

    l = 0; r = 1;
    while (l < diamondsTwo.size() && r < diamondsTwo.size()) {
        ll diff = abs(diamondsTwo[r] - diamondsTwo[l]);
        while (diff <= K) {
            r++;
            diff = abs(diamondsTwo[r] - diamondsTwo[l]); 
        }

        if (r - l > ansTwo) {
            ansTwo = r - l;
            twoStart = l; twoEnd = r;
        }
        // cout << r << " " << l << "\n";
        l++;
    }

    cout << ansOne + ansTwo << "\n";
    // cout << ansOne + ansTwo << " " << oneStart << " " << oneEnd << " " << twoStart << " " << twoEnd << "\n";
    return 0;
}