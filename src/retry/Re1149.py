N = int(input())
costs = [list(map(int, input().split())) for _ in range(N)]
dp = [[0] * 3 for _ in range(N)]

dp[0] = costs[0][:]

for i in range(1, N):
    for j in range(3):
        dp[i][j] = costs[i][j] + min([dp[i - 1][k] for k in range(3) if j != k])

print(min(dp[N - 1]))
