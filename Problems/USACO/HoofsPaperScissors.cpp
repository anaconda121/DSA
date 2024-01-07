// http://www.usaco.org/index.php?page=viewproblem2&cpid=691

#include <bits/stdc++.h>

using namespace std;

vector<int> hoofsW, paperW, scissorsW;
vector<char> fJMoves;
int N = 0; 
int ans = INT_MIN;

void setIO(string name, bool includeout=false) {
    ios_base::sync_with_stdio(0); cin.tie(0);
    freopen((name+".in").c_str(), "r", stdin);
    if (includeout) {
        freopen((name+".out").c_str(), "w", stdout);
    }
}

int winner(char m1, char m2) {
    if (m1 == 'H') {
        if (m2 == 'S') return 1;
        return 0;
    } else if (m1 == 'P') {
        if (m2 == 'H') return 1;
        return 0;
    } else {
        if (m2 == 'P') return 1;
        return 0;
    }
}

vector<int> movePSum(char move) {
    vector<int> ans; ans.push_back(0);
    int ctr = 0;
    for (char c: fJMoves) {
        int w = winner(c, move);
        ans.push_back(ans[ctr] + w);
        ctr++;
    }
    return ans;
}

int main() {
    setIO("hps", true);
    cin >> N;
    for (int i = 0; i < N; i++) {
        char s; cin >> s;
        fJMoves.push_back(s);
    }

    hoofsW = movePSum('H');
    paperW = movePSum('P');
    scissorsW = movePSum('S');

    for (int i = 1; i < N + 1; i++) {
        int currHW = hoofsW[i] - hoofsW[0];
        int currPW = paperW[i] - paperW[0];
        int currSW = scissorsW[i] - scissorsW[0];

        // process hoof max move 
        ans = max(ans, max(currHW + (scissorsW[N] - scissorsW[i - 1]), currHW + (paperW[N] - paperW[i - 1])));
        ans = max(ans, max(currPW + (hoofsW[N] - hoofsW[i - 1]), currPW + (scissorsW[N] - scissorsW[i - 1])));
        ans = max(ans, max(currSW + (hoofsW[N] - hoofsW[i - 1]), currSW + (paperW[N] - paperW[i - 1])));
    }
    
    cout << ans << "\n";
    return 0;
}