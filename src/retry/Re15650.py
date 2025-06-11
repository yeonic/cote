N, M = list(map(int, input().split()))

visited = [0] * (N + 1)
selected = [0] * M


def dfs(depth):
    if depth == M:
        for s in selected:
            print(s, end=' ')
        print()
        return

    st = 1 if depth == 0 else selected[depth - 1] + 1
    for i in range(st, N + 1):
        selected[depth] = i
        visited[i] = 1
        dfs(depth + 1)
        visited[i] = 0


dfs(0)
