# dp[N] -> N을 1로 만들기 위한 최소 연산의 수
# 그러면 -> dp[N] => min(dp[N//2], dp[N//3], dp[N-1]) + 1
# dp[1] = 0
import sys

N = int(input())
dp = [0 for _ in range(1_000_001)]

for i in range(2, N + 1):
    temp = sys.maxsize
    if i % 2 == 0:
        temp = min(temp, dp[i // 2])
    if i % 3 == 0:
        temp = min(temp, dp[i // 3])
    temp = min(temp, dp[i - 1])
    dp[i] = temp + 1

print(dp[N])
