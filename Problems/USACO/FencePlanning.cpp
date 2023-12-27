// http://www.usaco.org/index.php?page=viewproblem2&cpid=944

#include <bits/stdc++.h>

using namespace std;

const int MAXN = 1e5 + 5;

int N, M, ans = INT_MAX;
vector<int> adj[MAXN];
vector<pair<int, int>> farm;
vector<vector<int>> components;
vector<int> currComponent;
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
    currComponent.push_back(s);

    for (int n: adj[s]) {
        dfs(n);
    }
}

int perimeter(vector<pair<int, int>>& points) {
    if (points.empty()) return 0;

    int minX = points[0].first;
    int maxX = points[0].first;
    int minY = points[0].second;
    int maxY = points[0].second;

    for (const auto& p : points) {
        minX = min(minX, p.first);
        maxX = max(maxX, p.first);
        minY = min(minY, p.second);
        maxY = max(maxY, p.second);
    }

    int width = maxX - minX;
    int height = maxY - minY;

    return 2 * (width + height);
}

int main() {
    setIO("fenceplan", true);
    cin >> N >> M;

    for (int i = 0; i < N; i++) {
        int x, y;
        cin >> x >> y;
        farm.push_back({x, y});
    }

    for (int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;
        a--; b--;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    for (int i = 0; i < N; i++) {
        if (!visited[i]) {
            dfs(i);
            components.push_back(currComponent);
            currComponent = vector<int>(0);
        }
    }

    for (int i = 0; i < components.size(); i++) {
        vector<pair<int, int>> currPoints;
        
        for (int j = 0; j < components[i].size(); j++) {
            currPoints.push_back(farm[components[i][j]]);
        }

        int curr = perimeter(currPoints);
        ans = min(ans, curr);
    }

    cout << ans << "\n";

    return 0;
}