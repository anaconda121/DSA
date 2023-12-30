#include <bits/stdc++.h>
 
using namespace std;
 
const int MAXN = 2e5 + 5;
 
int N;
vector<int> adj[MAXN];
map<int, int> cycleLengths;
bool visited[MAXN];
int ans[MAXN], inCycle[MAXN];
 
// void setIO(string name, bool includeout=false) {
//     ios_base::sync_with_stdio(0); cin.tie(0);
//     freopen((name+".in").c_str(), "r", stdin);
//     if (includeout) {
//         freopen((name+".out").c_str(), "w", stdout);
//     }
// }
 
pair<int, int> advance(int a, int b) {
    pair<int, int> advanced = {a, b};
    advanced.first = adj[a][0];
    int tmp = adj[b][0];
    advanced.second = adj[tmp][0];
    return advanced;
}
 
void floyd(int s) {
    visited[s] = true;
 
    int a = adj[s][0];
    int b = adj[a][0];
    while (a != b) { pair<int, int> newPos = advance(a, b); a = newPos.first; b = newPos.second; }
 
    a = adj[s][0];
    while (a != b) { pair<int, int> newPos = advance(a, b); a = newPos.first; b = newPos.second; }
 
    b = adj[a][0];
    vector<int> cycle;
    int length = 1;
    cycle.push_back(b);
    while (a != b) { b = adj[b][0]; length++; cycle.push_back(b); inCycle[b] = 1; visited[b] = true; }
 
    for (int i: cycle) {
        // cout << i << " ";
        // if (cycleLengths.count(i) != 0) {
        //     cycleLengths[i] = min(cycleLengths[i], length);
        // } else {
            cycleLengths[i] = length;
        // }
    }
    // cout << "---------\n";
}
 
int main() {
    // setIO("input", false);
    cin >> N;
 
    for (int i = 0; i < N; i++) {
        int a;
        cin >> a;
        a--;
        adj[i].push_back(a);
    }
 
    for (int i = 0; i < N; i++) {
        if (!visited[i]) {
            // memset(&visited, false, sizeof(visited));
            floyd(i);
        }
    }
 
    // for (auto i: cycleLengths) {
    //     cout << i.first << " " << i.second << "\n";
    // }
 
    for (int i = 0; i < N; i++) {
        if (adj[i][0] == i) ans[i] = 1;
        else if (cycleLengths.count(i) != 0) ans[i] = cycleLengths[i];
        else {
            int ret = i;
            int dist = 0;
            while (cycleLengths.count(ret) == 0) {
                ret = adj[ret][0];
                dist++;
            }
            // memset(&visited, false, sizeof(visited));
            ans[i] = cycleLengths[ret] + dist;
        }
    }
 
    for (int i = 0; i < N; i++) {
        cout << ans[i] << " ";
    }
    cout << "\n";
 
    return 0;
}