N, S = list(map(int, input().split()))
arr = list(map(int, input().split()))

visited = [0] * N
selected = [-100001] * N
count = 0


def dfs(depth, bef_idx):
    global count

    if depth == N:
        return

    for i in range(bef_idx + 1, N):
        if not visited[i]:
            selected[depth] = arr[i]
            visited[i] = 1
            if sum(selected[:depth + 1]) == S:
                count += 1
            dfs(depth + 1, i)
            visited[i] = 0


# 여기서, 각 뎁스마다 선택된 list의 값의 합을 구해야 한다.

dfs(0, -1)
print(count)
