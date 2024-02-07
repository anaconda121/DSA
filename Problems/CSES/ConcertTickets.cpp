// https://cses.fi/problemset/result/8254883/

#include <bits/stdc++.h>
 
using namespace std;

int N, M;
multiset<int> tickets;
// set<int> maxPrices;

void setIO(string name, bool includeout=false) {
    ios_base::sync_with_stdio(0); cin.tie(0);
    freopen((name+".in").c_str(), "r", stdin);
    if (includeout) {
        freopen((name+".out").c_str(), "w", stdout);
    }
}

int main() {
    // setIO("input", false);
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        int a; cin >> a;
        tickets.insert(a);
    }

    for (int i = 0; i < M; i++) {
        int price; cin >> price;
        auto it = tickets.lower_bound(price);
        
        if (tickets.size() == 0 || (it == tickets.end() && *(--it) > price) || (it == tickets.begin() && *it > price)) {
            cout << "-1\n";
        } else {
            if (*it <= price) {
                cout << *it << "\n";
                tickets.erase(tickets.find(*it));
            } else if (*it > price) {
                // *it > price
                int n = *(--it);
                if (n <= price) {
                    cout << n << "\n";
                    tickets.erase(tickets.find(n));
                }
            }
        }

    }

    return 0;
}