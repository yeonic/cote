n = int(input())
triangle = []
dp = [[0] * (i + 1) for i in range(n)]

for _ in range(n):
    triangle.append(list(map(int, input().split())))

dp[0][0] = triangle[0][0]

for i in range(1, n):
    for j, num in enumerate(triangle[i]):
        if j == 0:
            dp[i][j] = dp[i - 1][0] + num
            continue
        if j == len(triangle[i]) - 1:
            dp[i][j] = dp[i - 1][len(dp[i - 1]) - 1] + num
            continue

        dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + num

print(max(dp[n - 1]))
