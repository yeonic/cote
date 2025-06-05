N = int(input())


def recur(n):
    if n == 1:
        return ['*']
    new_n = n // 3
    ret = []
    little = recur(new_n)
    for l in little:
        ret.append(l * 3)
    for l in little:
        ret.append(l + ' ' * new_n + l)
    for l in little:
        ret.append(l * 3)
    return ret


arr = recur(N)
print(str.join('\n', arr))
