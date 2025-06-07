N = int(input())
ans = [[' ' for _ in range(6561)] for _ in range(6561)]


def recur(x, y, n):
    if n == 3:
        draw(x, y)
        return

    new_n = n // 3
    for i in range(3):
        for j in range(3):
            if i == 1 and j == 1:
                continue
            recur(x + i * new_n, y + j * new_n, new_n)


def draw(x, y):
    for i in range(3):
        for j in range(3):
            if i == 1 and j == 1:
                continue
            ans[x + i][y + j] = '*'


recur(0, 0, N)

for a in range(N):
    for b in range(N):
        print(ans[a][b], end='')
    print()
