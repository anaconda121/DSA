#include <bits/stdc++.h>

using namespace std;
 
#define ll long long
 
vector<ll> arr, prevArr, tmpArr;
ll N, X, l, r, currSum = 0;
bool leftLast = false;

void setIO(string name, bool includeout=false) {
    ios_base::sync_with_stdio(0); cin.tie(0);
    freopen((name+".in").c_str(), "r", stdin);
    if (includeout) {
        freopen((name+".out").c_str(), "w", stdout);
    }
}
 
bool output(ll l, ll m, ll r) {
    ll lPos, mPos, rPos = 0;
    lPos = (find(prevArr.begin(), prevArr.end(), l) - prevArr.begin());
    prevArr[lPos] = -1;  

    mPos = (find(prevArr.begin(), prevArr.end(), m) - prevArr.begin());
    prevArr[mPos] = -1;

    rPos = (find(prevArr.begin(), prevArr.end(), r) - prevArr.begin());
    if (lPos >= N || mPos >= N || rPos >= N) { return false; }
    cout << lPos + 1 << " " << mPos + 1 << " " << rPos + 1 << "\n";
    return true;
}

int main() {
    setIO("input", false);
    cin >> N >> X;
    for (int i = 0; i < N; i++) {
        int a; cin >> a; arr.push_back(a); prevArr.push_back(a); tmpArr.push_back(a);
    }

    set<ll> unqVals(arr.begin(), arr.end());
    vector<ll> finalArr(unqVals.begin(), unqVals.end());
    sort(finalArr.begin(), finalArr.end());

    l = 0; r = finalArr.size() - 1;

    while (l < finalArr.size() && r > 0) {
        currSum = finalArr[l] + finalArr[r];
        ll remainder = X - currSum;
        cout << currSum << " " << remainder << " " << l << " " << r << "\n";

        if (remainder <= 0) {
            // currSum is greater
            r--;
        } else {
            ll lo = l+1; ll hi = r-1; ll closest = 0; ll minRemainder = LLONG_MAX; ll maxRemainder = LLONG_MIN;

            for (int i = l + 1; i < r; i++) {
                closest = min(abs(remainder - closest), abs(remainder - finalArr[i]));
                minRemainder = min(minRemainder, finalArr[i]);
                maxRemainder = max(maxRemainder, finalArr[i]);
                if (finalArr[i] == remainder) {
                    bool done = output(finalArr[l], finalArr[i], finalArr[r]);
                    if (done) return 0;
                }
            }

            // while (lo <= hi) {
            //     int mid = lo + (hi - lo + 1) / 2;
            //     closest = min(abs(X - closest), abs(X - finalArr[mid]));
            //     if (finalArr[mid] > remainder) {
            //         hi = mid - 1;
            //     } else if (finalArr[mid] < remainder) {
            //         lo = mid + 1;
            //     } else if (finalArr[mid] == remainder) {
            //         cout << "proposed: " << l << " " << mid << " " << r << "\n";
            //         bool done = output(finalArr[l], finalArr[mid], finalArr[r]);
            //         if (done) return 0;
            //         if (abs(hi - lo) == 1) break;
            //     }
            // }

            // if (closest < X) { l++; }
            // else { r--; }

            // if (currSum + minRemainder > X) {
            //     r--;
            // } else if (currSum + maxRemainder < X) {
            //     l++;
            // } else {
            //     l++;
            // }
            l++;
            
        }

    }

    cout << "IMPOSSIBLE \n";
    return 0;
}