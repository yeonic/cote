N = int(input())


def star(n):
    if n == 3:
        return ['  *  ', ' * * ', '*****']
    new_n = n // 2
    unit = star(new_n)
    top = [' ' * new_n + s + ' ' * new_n for s in unit]
    bottom = [s + ' ' + s for s in unit]
    return top + bottom


arr = star(N)

print(str.join('\n', arr))
