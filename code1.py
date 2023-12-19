def calc(l, r):
    global dp, calced, cost
    ans = dp[l][r]
    if calced[l][r]:
        return ans
    calced[l][r] = True
    k = min(l, r) - 1
    if k == 0:
        ans = cost[0][l] + cost[r][0]
        return ans
    ans = min(cost[k][l] + calc(k, r), calc(l, k) + cost[r][k])
    return ans

def solve():
    global n, k, cost, calced, dp
    n, k = map(int, input().split())
    cost = [[0] * 1222 for _ in range(1222)]
    calced = [[False] * 1222 for _ in range(1222)]
    dp = [[0] * 1222 for _ in range(1222)]
    
    for i in range(n):
        for j in range(n):
            cost[i][j] = 0
            calced[i][j] = False
            
    for _ in range(k):
        x, y = map(int, input().split())
        cost[x][y] += 1

    for i in range(n - 1, -1, -1):
        for j in range(n):
            if i + 1 < n:
                cost[i][j] += cost[i + 1][j]
            if j - 1 >= 0:
                cost[i][j] += cost[i][j - 1]
            if i + 1 < n and j - 1 >= 0:
                cost[i][j] -= cost[i + 1][j - 1]

    print(calc(n - 1, n - 1))

if __name__ == "__main__":
    tests = int(input())
    for test in range(1, tests + 1):
        solve()
