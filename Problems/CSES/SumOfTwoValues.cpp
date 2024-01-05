// https://cses.fi/problemset/task/1640/

#include <bits/stdc++.h>

using namespace std;
 
#define ll long long
 
vector<ll> arr, prevArr;
ll N, X, l, r = 0;
 
void setIO(string name, bool includeout=false) {
    ios_base::sync_with_stdio(0); cin.tie(0);
    freopen((name+".in").c_str(), "r", stdin);
    if (includeout) {
        freopen((name+".out").c_str(), "w", stdout);
    }
}
 
void output(ll l, ll r) {
    ll lPos, rPos = 0;
    lPos = (find(prevArr.begin(), prevArr.end(), l) - prevArr.begin()) + 1;
    prevArr[lPos - 1] = -1;     
    // for (auto &i: prevArr) { cout << i << " "; } cout << "\n";
    rPos = (find(prevArr.begin(), prevArr.end(), r) - prevArr.begin()) + 1;
    if (lPos > N || rPos > N) { cout << "IMPOSSIBLE \n"; return; }
    else { cout << lPos << " " << rPos << "\n"; }
}
 
int main() {
    // setIO("input", false);
    cin >> N >> X;
    for (int i = 0; i < N; i++) {
        int a; cin >> a; arr.push_back(a); prevArr.push_back(a);
    }
    
    sort(arr.begin(), arr.end());

    // for (auto &i: arr) { cout << i << " "; } cout << "\n"; 
 
    if (arr.size() == 1) {
        cout << "IMPOSSIBLE";
        return 0;
    }
    
    if (arr[l] + arr[N-1] == X) {
        output(arr[l], arr[N - 1]);
        return 0;
    }

    l = 0; r = N - 1;
    while (l <= r) {
        // cout << l << " " << r << " " << psum[r] - psum[l - 1] << "\n";
        if (arr[r] + arr[l] < X) {
            l++;
        } else if (arr[r] + arr[l] == X) {
            output(arr[l], arr[r]);
            return 0;
        } else {
            r--;
        }
    }
    
    cout << "IMPOSSIBLE \n";
    return 0;
}