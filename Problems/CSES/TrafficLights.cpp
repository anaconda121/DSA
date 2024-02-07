#include <bits/stdc++.h>
 
using namespace std;

#define ll long long

multiset<ll> lights;

ll X = 0; ll N = 0; ll currMax = 0;
pair<ll, ll> currMaxPos = {-1, -1};

void setIO(string name, bool includeout=false) {
    ios_base::sync_with_stdio(0); cin.tie(0);
    freopen((name+".in").c_str(), "r", stdin);
    if (includeout) {
        freopen((name+".out").c_str(), "w", stdout);
    }
}

void interuptingInterval(ll a) {
    ll before2 = 0; ll after3 = 0;
    ll maxBefore = 0; ll maxAfter = 0; ll maxLeft = 0; ll maxRight = 0;

    auto it2 = lights.find(currMaxPos.first);
    auto it3 = lights.find(currMaxPos.second);

    if (currMaxPos.first > 0 && currMaxPos.second < X) {
        before2 = *(prev(it2));
        after3 = *(next(it3));
        maxBefore = currMaxPos.first - before2;
        maxAfter = after3 - currMaxPos.second;
        maxLeft = a - currMaxPos.first;
        maxRight = currMaxPos.second - a;
    } else if (currMaxPos.first == 0 && currMaxPos.second < X) {
        after3 = *(next(it3));
        maxAfter = after3 - currMaxPos.second;
        maxLeft = a - currMaxPos.first;
        maxRight = currMaxPos.second - a;
        maxBefore = 0;
    } else if (currMaxPos.first > 0 && currMaxPos.second == X) {
        before2 = *(prev(it2));
        maxBefore = currMaxPos.first - before2;
        maxAfter = 0;
        maxLeft = a - currMaxPos.first;
        maxRight = currMaxPos.second - a;
    } else if (currMaxPos.first == 0 && currMaxPos.second == X) {
        maxLeft = a - currMaxPos.first;
        maxRight = currMaxPos.second - a;
        maxBefore = 0;
        maxAfter = 0;
    }
    
    // cout << currMaxPos.first << " " << currMaxPos.second << " " << before2 << " " << after3 << "\n";
    // cout << maxBefore << " " << maxAfter << " " << maxLeft << " " << maxRight << "\n";

    currMax = max(maxBefore, max(maxAfter, max(maxLeft, maxRight)));
    if (currMax == maxBefore) {
        currMaxPos = {before2, currMaxPos.first};
    } else if (currMax == maxAfter) {
        currMaxPos = {currMaxPos.second, after3};
    } else if (currMax == maxLeft) {
        currMaxPos = {currMaxPos.first, a};
    } else {
        currMaxPos = {a, currMaxPos.second};
    }
}

int main() {
    // setIO("input", false);
    cin >> X >> N;
    lights.insert(0);
    lights.insert(X);

    for (ll i = 0; i < N; i++) {
        ll a; cin >> a;
        lights.insert(a);

        auto it = lights.find(a);
        ll before = *(prev(it));
        ll after = *(next(it));

        // cout << a << " " << after << " " << before << "\n";
        // for (auto i: lights) cout << i << " ";
        // cout << "\n";

        if (currMaxPos.first <= a && currMaxPos.second >= a) {
            // cout << "llerrupting\n";
            // llerrupting currMax llerval
            interuptingInterval(a);
        }

        if (after - a > a - before) {
            if (after - a > currMax) {
                currMax = after - a;
                currMaxPos = {a, after};
            }
        } else if (a - before > after - a) {
            if (a - before > currMax) {
                currMax = a - before;
                currMaxPos = {before, a};
            }
        } else {
            if (after - a > currMax) {
                currMax = after - a;
                currMaxPos = {a, after};
            }
        }
        
        cout << currMax << " ";
    }
    cout << "\n";

    return 0;
}