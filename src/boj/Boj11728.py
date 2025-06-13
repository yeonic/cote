N, M = list(map(int, input().split()))
A = list(map(int, input().split()))
B = list(map(int, input().split()))

cursor_a = 0
cursor_b = 0
result = []

while cursor_a < N or cursor_b < M:
    if cursor_a == len(A):
        result.append(B[cursor_b])
        cursor_b += 1
        continue

    if cursor_b == len(B):
        result.append(A[cursor_a])
        cursor_a += 1
        continue

    if A[cursor_a] < B[cursor_b]:
        result.append(A[cursor_a])
        cursor_a += 1
    else:
        result.append(B[cursor_b])
        cursor_b += 1

for r in result:
    print(r, end=' ')
