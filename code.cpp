#include <iostream>
using namespace std;
#define f first
#define s second
#define pb push_back
#define vi vector<int>
#define all(v) (v).begin(), (v).end()
#define sz(v) (int)(v).size()
#define f0(a) memset(a, 0, sizeof(a))
#define ll long long
#define pii pair<int, int>
#define mp make_pair
const int inf = (int)1e9;
int cost[1222][1222];
int calced[1222][1222], dp[1222][1222];
int n, k;
int calc(int l, int r) {
	int &ans = dp[l][r];
	if (calced[l][r]) return ans;
	calced[l][r] = true;
	int k = min(l, r) - 1;
	if (k == 0) {
		ans = cost[0][l] + cost[r][0];
		return ans;
	}
	ans = min(cost[k][l] + calc(k, r), calc(l, k) + cost[r][k]);
	return ans;
}
void Solve() {
	scanf("%d%d", &n, &k);
	for (int i = 0; i < n; ++i)
		for (int j = 0; j < n; ++j) {
			cost[i][j] = 0;
			calced[i][j] = false;
		}
	for (int i = 0; i < k; ++i) {
		int x, y;
		scanf("%d%d", &x, &y);
		cost[x][y] ++;
	}
	for (int i = n - 1; i >= 0; --i)
		for (int j = 0; j < n; ++j) {
			if (i + 1 < n) cost[i][j] += cost[i + 1][j];
			if (j - 1 >= 0) cost[i][j] += cost[i][j - 1];
			if (i + 1 < n && j - 1 >= 0) cost[i][j] -= cost[i + 1][j - 1];
		}
	cout << calc(n - 1, n - 1) << endl;
}
int main() {
	int tests;
	scanf("%d", &tests);
	for (int test = 1;test <= tests; ++test)
		Solve();
	return 0;
}