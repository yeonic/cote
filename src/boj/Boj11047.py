N, K = list(map(int, input().split()))
coins = []
for _ in range(N):
    coins.append(int(input()))
coins.sort(reverse=True)

count = 0
for coin in coins:
    if coin > K:
        continue
    count += K // coin
    K = K % coin

print(count)
