N, M = list(map(int, input().split()))

visited = [0] * (N + 1)
selected = [0] * M


def recur(depth):
    if depth == M:
        for i in selected:
            print(i, end=' ')
        print()
        return

    for i in range(1, N + 1):
        if not visited[i]:
            visited[i] = 1
            selected[depth] = i
            recur(depth + 1)
            visited[i] = 0


recur(0)
