// https://cses.fi/problemset/task/1620/

#include <bits/stdc++.h>
 
using namespace std;
 
int N, T = 0;
long long maxNum = LLONG_MIN; long long ans =LLONG_MAX;
vector<long long> nums;
 
void setIO(string name, bool includeout=false) {
    ios_base::sync_with_stdio(0); cin.tie(0);
    freopen((name+".in").c_str(), "r", stdin);
    if (includeout) {
        freopen((name+".out").c_str(), "w", stdout);
    }
}
 
bool f(long long minTime) {
    long long productsMade = 0;
    for (long long i: nums) {
        if (productsMade > LLONG_MAX - (minTime / i)) break;        
        productsMade += minTime / i;
    }
    return productsMade >= T;
}
 
long binarySearch(long long lo, long long hi) {
    while (lo <= hi) {
        long long mid = lo + (hi - lo + 1) / 2;
        if (f(mid)) {
            ans = min(ans, mid);
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }
    return lo;
}
 
int main() {
    cin >> N >> T;
 
    for (int i = 0; i < N; i++) {
        long long a; cin >> a; maxNum = max(maxNum, a);
        nums.push_back(a);
    }
    
    binarySearch(1, 1e18);
    cout << ans << "\n";
 
    return 0;
}