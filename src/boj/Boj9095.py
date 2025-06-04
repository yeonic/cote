# 1, 2, 3의 합으로 나타내는 경우의 수
# dp[N] -> N을 1, 2, 3의 합으로 나타내는 경우의 수
# dp[1] -> 1, dp[2] -> 1+1, 2, dp[3] -> 1+2, 1+1+1, 2+1, 3
n = int(input())
dp = [0 for _ in range(11)]
dp[1] = 1
dp[2] = 2
dp[3] = 4

for i in range(4, 11):
    dp[i] += dp[i - 1]
    dp[i] += dp[i - 2]
    dp[i] += dp[i - 3]

for i in range(n):
    N = int(input())
    print(dp[N])
