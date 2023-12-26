// http://www.usaco.org/index.php?page=viewproblem2&cpid=788

#include <bits/stdc++.h>

using namespace std;

const int MAXN = 5005;

vector<pair<int, int>> adj[MAXN];
bool visited[MAXN];
int rel[MAXN];
int N, Q, recommendedVids;

void setIO(string name, bool includeout=false) { // name is nonempty for USACO file I/O
    ios_base::sync_with_stdio(0); cin.tie(0); // see Fast Input & Output
    freopen((name+".in").c_str(), "r", stdin); // see Input & Output
    if (includeout) {
        freopen((name+".out").c_str(), "w", stdout);
    }
}

void bfs(int start, int k) {
    queue<int> q;
    visited[start] = true;
    q.push(start);

    while (!q.empty()) {
        int curr = q.front();
        q.pop();

        if (rel[curr] >= k && curr != start) {
            recommendedVids++;
        }

        for (pair<int, int> n: adj[curr]) {
            if (!visited[n.first]) {
                visited[n.first] = true;
                rel[n.first] = min(rel[curr], n.second);
                q.push(n.first);
            }
        }
    }
}

int main() {
    setIO("mootube", true);
    cin >> N >> Q;

    for (int i = 0; i < N - 1; i++) {
        int s, e, w;
        cin >> s >> e >> w;
        adj[s].push_back({e, w});
        adj[e].push_back({s, w});
    }

    for (int i = 0; i < Q; i++) {
        int k, v;
        cin >> k >> v;
        
        fill(rel, rel + MAXN, INT_MAX);
        memset(&visited, false, sizeof(visited));
        recommendedVids = 0;

        bfs(v, k);

        cout << recommendedVids << "\n";
    }

    return 0;
}