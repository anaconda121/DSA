// http://www.usaco.org/index.php?page=viewproblem2&cpid=738

#include <bits/stdc++.h>

using namespace std;

map<int, int> farm;
int N = 0; 
int ans = INT_MIN;

void setIO(string name, bool includeout=false) {
    ios_base::sync_with_stdio(0); cin.tie(0);
    freopen((name+".in").c_str(), "r", stdin);
    if (includeout) {
        freopen((name+".out").c_str(), "w", stdout);
    }
}

int main() {
    setIO("pairup", true);
    cin >> N;

    for (int i = 0; i < N; i++) {
        int f, t; cin >> f >> t;
        farm[t] = f;
    }

    auto left = farm.begin();
    auto right = farm.end();

    if (!farm.empty()) {
        --right;
    }

    while (left != right) {
        ans = max(ans, left->first + right->first);
        if (left->second < right-> second) {
            right->second -= left->second;
            left->second = 0;
            left++;
        } else if (left->second > right->second) {
            left->second -= right->second;
            right->second = 0;
            right--;
        } else {
            left->second = 0; right->second = 0;
            left++; right--;
        }
    }

    cout << ans << "\n";
    return 0;
}