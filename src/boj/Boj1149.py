# i번째에서 0, 1, 2를 선택할 때, 최소값

N = int(input())
cost = [list(map(int, input().split())) for _ in range(N)]
dp = [[0] * 3 for i in range(N)]

dp[0] = cost[0][:]

for i in range(1, N):
    for j in range(3):
        dp[i][j] = cost[i][j] + min(dp[i - 1][k] for k in range(3) if k != j)

print(min(dp[N - 1]))
