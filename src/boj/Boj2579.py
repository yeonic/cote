N = int(input())
stairs = [-1] + [int(input()) for _ in range(N)]
dp = [0 for _ in range(N + 1)]

if N >= 1:
    dp[1] = stairs[1]
if N >= 2:
    dp[2] = dp[1] + stairs[2]
if N >= 3:
    for i in range(3, N + 1):
        # 이런 식으로 점화식을 통해서 조건을 나타낼 수도 있음
        dp[i] = max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i])

print(dp[N])
