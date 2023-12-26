// https://cses.fi/problemset/task/1674/

#include <bits/stdc++.h>

using namespace std;

const int MAXN = 2e5;

vector<int> adj[MAXN];
int counts[MAXN];
int N;

void dfs(int i) {
    counts[i] = 1;
    for (int n: adj[i]) {
        dfs(n);
        counts[i] += counts[n];
    }
}

int main() {
    cin >> N;

    for (int i = 2; i < N + 1; i++) {
        int boss;
        cin >> boss;
        adj[boss].push_back(i);
    }

    dfs(1);

    for (int i = 1; i < N + 1; i++) {
        cout << counts[i] - 1;
        if (i != N) cout << " ";
    }
    cout << "\n";

    return 0;
}