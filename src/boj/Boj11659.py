N, M = list(map(int, input().split()))
arr = [0] + list(map(int, input().split()))
dp = [0, arr[1]] * (N + 1)

for i in range(2, N + 1):
    dp[i] = dp[i - 1] + arr[i]

s = []
for _ in range(M):
    i, j = list(map(int, input().split()))

    if i == 1:
        s.append(str(dp[j]))
        continue

    s.append(str(dp[j] - dp[i - 1]))

print(str.join('\n', s))
