# fibo(n) -> fibo(n-1)의 0인 경우와 1인 경우의 합 + fibo(n-2)의 0인 경우와 1인 경우의 합
# fibo(0) -> 1 0
# fibo(1) -> 0 1
# fibo(2) -> 1 1
# fibo(3) -> 1 2
T = int(input())
dp = [[1, 0], [0, 1]] + [[0, 0] for _ in range(39)]
for i in range(2, 41):
    dp[i][0], dp[i][1] = dp[i - 1][0] + dp[i - 2][0], dp[i - 1][1] + dp[i - 2][1]

sol = []
for _ in range(T):
    N = int(input())
    sol.append(f'{dp[N][0]} {dp[N][1]}')

print(str.join('\n', sol))
