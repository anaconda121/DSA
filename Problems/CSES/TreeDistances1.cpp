#include <bits/stdc++.h>

using namespace std;

const int MAXN = 2e5 + 5;

int N, maxDist = INT_MIN;
vector<int> adj[MAXN];
bool visited[MAXN];
int dist[MAXN];
map<int, int> maxComps;
vector<int> furthest, ans;
map<int, set<int>> subtrees;

void setIO(string name, bool includeout=false) {
    ios_base::sync_with_stdio(0); cin.tie(0);
    freopen((name+".in").c_str(), "r", stdin);
    if (includeout) {
        freopen((name+".out").c_str(), "w", stdout);
    }
}

set<int> dfs(int s, int d) {
    if (visited[s]) return set<int>{};
    visited[s] = true;
    dist[s] = d;

    for (int n: adj[s]) {
        subtrees[s].insert(n);
        set<int> curr = dfs(n, d + 1);
        subtrees[s].insert(curr.begin(), curr.end());
    }
    
    return subtrees[s];
}

int findMaxDist(int s, int p, int ans) {
    if (visited[s] || !subtrees.count(s)) return 0;
    visited[s] = true;

    ans = max(ans, abs(dist[s] - dist[1]));
    // cout << "curr: " << s << " " << ans << " " << adj[s].size() << "\n";
    for (int n: adj[s]) {
        if (n != p)
            ans = max(ans, findMaxDist(n, s, ans));
    }

    // cout << "final answer: " << s << " " << ans << "\n";

    return ans;
}

int main() {
    // setIO("input");
    cin >> N;

    for (int i = 0; i < N; i++) {
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    memset(&dist, 0, sizeof(dist));
    memset(&visited, false, sizeof(visited));
    dfs(1, 0);

    // for (int i = 1; i < N + 1; i++) {
    //     for (int j: subtrees[i]) {
    //         cout << j << " ";
    //     }
    //     cout << "\n";
    // }

    for (int i: adj[1]) {
        memset(&visited, false, sizeof(visited));
        maxComps[i] = findMaxDist(i, 1, INT_MIN);
    }

    // for (auto p: maxComps) {
    //     cout << p.first << " " << p.second << "\n";
    // }

    for (int i = 1; i < N + 1; i++) {
        int case1 = INT_MIN;
        for (int j: subtrees[i]) {
            case1 = max(case1, abs(dist[i] - dist[j]));
        }

        int case2 = 0;
        int distTo1 = abs(dist[i] - dist[1]);
        
        for (auto p: maxComps) {
            if (!subtrees[p.first].count(i)) {
                case2 = max(case2, p.second);
            }
        }

        case2 += distTo1;

        ans.push_back(max(case1, case2));

        // cout << "here " << case1 << " " << case2 << " " << distTo1 << "\n";
    }

    // cout << "---------\n";
    
    for (int i: ans) {
        cout << i << " ";
    }
    cout << "\n";


    return 0;
}