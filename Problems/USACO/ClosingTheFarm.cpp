// http://www.usaco.org/index.php?page=viewproblem2&cpid=644

#include <bits/stdc++.h>

using namespace std;

const int MAXN = 3000 + 5;

int N, M = 0;
vector<int> adj[MAXN];
set<pair<int, int>> closedPaths;
set<int> closedNodes;
bool visited[MAXN];

void setIO(string name, bool includeout=false) {
    ios_base::sync_with_stdio(0); cin.tie(0);
    freopen((name+".in").c_str(), "r", stdin);
    if (includeout) {
        freopen((name+".out").c_str(), "w", stdout);
    }
}

void dfs(int s) {
    if (visited[s]) return;
    visited[s] = true;

    for (int n: adj[s]) {
        pair<int, int> currCordsOne = {s, n};
        pair<int, int> currCordsTwo = {n, s};
        if (!closedPaths.count(currCordsOne) || !closedPaths.count(currCordsTwo)) {
            dfs(n);
        }
    }
}

int numberComponents() {
    int ans = 0;
    memset(&visited, false, sizeof(visited));

    for (int i = 0; i < N; i++) {
        if (!visited[i] && !closedNodes.count(i)) {
            ans++;
            dfs(i);
        }
    }
    return ans;
}

int main() {
    setIO("closing", true);
    cin >> N >> M;

    for (int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;
        a--; b--;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    if (numberComponents() == 1) cout << "YES" << "\n";
    else cout << "NO" << "\n";

    for (int i = 0; i < N - 1; i++) {
        int c;
        cin >> c;
        c--;

        for (int n: adj[c]) {
            closedPaths.insert({c, n});
            closedPaths.insert({n, c});
        }
        closedNodes.insert(c);

        if (numberComponents() == 1) cout << "YES" << "\n";
        else cout << "NO" << "\n";
    }

    return 0;
}