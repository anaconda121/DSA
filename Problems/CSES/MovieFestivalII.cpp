#include <bits/stdc++.h>
 
using namespace std;
 
int N, K, visitedCount, ans = 0;
vector<pair<int, int>> times;
 
void setIO(string name, bool includeout=false) {
  ios_base::sync_with_stdio(0); cin.tie(0);
  freopen((name+".in").c_str(), "r", stdin);
  if (includeout) {
    freopen((name+".out").c_str(), "w", stdout);
  }
}
 
bool cmp(pair<int, int> &a, pair<int, int> &b) {
  return a.second < b.second;
}
 
int main() {
  // setIO("input", false);
  cin >> N >> K;
  for (int i = 0; i < N; i++) {
    int a, b; cin >> a >> b;
    times.push_back({a, b});
  }
 
  sort(times.begin(), times.end(), cmp);
 
  // for (auto i: times) {
  //   cout << i.first << " " << i.second << "\n";
  // }
 
  int currEnd[K];
  bool visited[N];
  memset(&currEnd, 0, sizeof(currEnd));
  memset(&visited, false, sizeof(visited));

  for (int i = 0; i < K; i++) {
    int ptr = 0;
    while (visitedCount < N && ptr < N) {
      if (!visited[ptr] && currEnd[i] <= times[ptr].first) {
        currEnd[i] = times[ptr].second;
        visited[ptr] = true;
        visitedCount++;
        ans++;
        if (visitedCount == N) {
          cout << N << "\n";
          return 0;
        }
      }
      // cout << ans << " " << ptr << "\n";
      ptr++;
    }
  }
 
  cout << ans << "\n";
 
  return 0;
}