N = int(input())
arr = [list(map(int, input())) for _ in range(N)]
s = ''


def recur(start_x, start_y, width):
    global s
    if width == 1:
        s += str(arr[start_x][start_y])
        return

    # 전체가 같은 픽셀인지 체크
    temp = arr[start_x][start_y]
    all_same = True
    for i in range(start_x, start_x + width):
        for j in range(start_y, start_y + width):
            if temp != arr[i][j]:
                all_same = False
                break
            temp = arr[i][j]

    if all_same:
        s += str(temp)
        return

    new_width = width // 2
    s += '('
    recur(start_x, start_y, new_width)
    recur(start_x, start_y + new_width, new_width)
    recur(start_x + new_width, start_y, new_width)
    recur(start_x + new_width, start_y + new_width, new_width)
    s += ')'


recur(0, 0, N)
print(s)
