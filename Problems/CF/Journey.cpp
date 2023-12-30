// https://codeforces.com/contest/839/problem/C

#include <bits/stdc++.h>

using namespace std;

vector<vector<int>> adj;
int N;
double deadEnds, totalLen = 0;

void dfs(int c, int currLen) {
    // if (visited[c]) return;
    // visited[c] = true;

    if (adj[c].size() == 0) {
        deadEnds++;
        totalLen += currLen;
    }

    for (int n: adj[c]) {
        dfs(n, currLen + 1);
    }
}

int main() {
    cin >> N;
    adj = vector<vector<int>>(N + 1);

    for (int i = 0; i < N - 1; i++) {
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
    }

    dfs(1, 0);

    cout << setprecision(4) << totalLen / deadEnds << "\n";
    return 0;
}