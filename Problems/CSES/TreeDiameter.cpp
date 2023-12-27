#include <bits/stdc++.h>

using namespace std;

const int MAXN = 2e5 + 5;

int N, maxDist = 0;
vector<int> adj[MAXN];
bool visited[MAXN];

void dfs(int curr, int depth) {
    if (visited[curr]) return;
    visited[curr] = true;
    int maxLeftDepth, maxRightDepth = 0;

    for (int n: adj[curr]) {
        dfs(n, depth + 1);
    }

    maxDist = max(maxDist, (maxLeftDepth - depth) + (maxRightDepth - depth) + 1);

}

int main() {
    cin >> N;

    for (int i = 0; i < N - 1; i++) {
        int s, e;
        cin >> s >> e;
        adj[s].push_back(e);
    }

    return 0;
}