from collections import deque

N = int(input())
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]


def bfs(pic, visited):
    count = 0

    for i in range(N):
        for j in range(N):
            if visited[i][j] == 1:
                continue

            q = deque()
            q.append([i, j])
            visited[i][j] = 1

            color = pic[i][j]
            count += 1

            while q:
                cx, cy = q.popleft()
                for x, y in zip(dx, dy):
                    nx = cx + x
                    ny = cy + y
                    if nx < 0 or nx >= N or ny < 0 or ny >= N:
                        continue
                    if visited[nx][ny] == 1 or pic[nx][ny] != color:
                        continue
                    q.append([nx, ny])
                    visited[nx][ny] = 1
    return count


norm = [list(map(str, input())) for _ in range(N)]
visited_n = [[0] * N for _ in range(N)]

rg = [['R' if c == 'G' else c for c in row] for row in norm]
visited_rg = [[0] * N for _ in range(N)]

count = [0, 0]
count[0] = bfs(norm, visited_n)
count[1] = bfs(rg, visited_rg)
print(f'{count[0]} {count[1]}')
