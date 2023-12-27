// http://www.usaco.org/index.php?page=viewproblem2&cpid=668

#include <bits/stdc++.h>

using namespace std;

const int MAXN = 205;

struct Point {
    int x, y, p;
};

vector<Point> adj[MAXN];
vector<Point> farm;
bool visited[MAXN];
int N, curr, ans = 0;

void setIO(string name, bool includeout=false) { // name is nonempty for USACO file I/O
    ios_base::sync_with_stdio(0); cin.tie(0); // see Fast Input & Output
    freopen((name+".in").c_str(), "r", stdin); // see Input & Output
    if (includeout) {
        freopen((name+".out").c_str(), "w", stdout);
    }
}

void dfs(int s, int prev) {
    if (visited[s]) return;
    visited[s] = true;

    for (int i = 0; i < N; i++) {
        if (i != s && i != prev) {
            Point n = farm[i];
            Point c = farm[s];
            double dist = sqrt(pow(c.x - n.x, 2) + pow(c.y - n.y, 2));
            if (dist <= c.p && !visited[i]) {
                // cout << "reached: " << n.x << " " << n.y << " " << n.p << " from " << c.x << " " << c.y << " " << c.p << "\n";
                curr++;
                dfs(i, s);
            }
        }
    }
}

int main() {
    setIO("moocast", true);
    cin >> N;

    for (int i = 0; i < N; i++) {
        int x, y, p;
        cin >> x >> y >> p;
        farm.push_back({x, y, p});
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (j != i) {
                adj[i].push_back(farm[j]);
            }
        }
    }

    // for (int i = 0; i < N; i++) {
    //     cout << i << " " << adj[i].size() << "\n";
    //     for (int j = 0; j < N; j++) {
    //         cout << adj[i][j].x << " " << adj[i][j].y << " " << adj[i][j].p << "\n";
    //     }
    //     cout << "--------";
    // }

    for (int i = 0; i < N; i++) {
        curr = 1;
        memset(&visited, false, sizeof(visited));
        // cout << i << "\n"; 
        dfs(i, -1);
        ans = max(ans, curr);
    }

    cout << ans << "\n";

    return 0;
}