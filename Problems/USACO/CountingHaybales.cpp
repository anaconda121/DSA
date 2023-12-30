// http://www.usaco.org/index.php?page=viewproblem2&cpid=666

#include <bits/stdc++.h>

using namespace std;

const int MAXN = 1e5 + 5;

int N, Q = 0;
vector<int> haybales;

void setIO(string name, bool includeout=false) {
    ios_base::sync_with_stdio(0); cin.tie(0);
    freopen((name+".in").c_str(), "r", stdin);
    if (includeout) {
        freopen((name+".out").c_str(), "w", stdout);
    }
}

int main() {
    setIO("haybales", true);
    cin >> N >> Q;

    for (int i = 0; i <  N; i++) {
        int a; cin >> a;
        haybales.push_back(a);
    }
    sort(haybales.begin(), haybales.end());

    for (int i = 0; i < Q; i++) {
        int s, e; cin >> s >> e;
        auto a = lower_bound(haybales.begin(), haybales.end(), s) - haybales.begin();
        auto b = upper_bound(haybales.begin(), haybales.end(), e) - haybales.begin();
        cout << b - a << "\n";
    }

    return 0;
}