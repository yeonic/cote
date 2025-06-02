# 2 x n 직사각형을 1X2, 2X1
# 방법의 수를 구하라
# n을 1 혹은 2의 합으로 나타내는 방법의 수
# dp[N]은 n을 1, 2의 합으로 나타내는 방법의 수
# dp[1] = 1
# dp[2] = 2
# dp[N]은 dp[N-1] + dp[N-2]

N = int(input())
dp = [0] * (N + 1)

if N >= 1:
    dp[1] = 1
if N >= 2:
    dp[2] = 2
if N >= 3:
    for i in range(3, N + 1):
        dp[i] = dp[i - 1] + dp[i - 2]

print(dp[N] % 10007)
