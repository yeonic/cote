ex = [10, 2, -1, 9, 4, -20, -23, 5, 23, 30]


def merge_sort(arr):
    if len(arr) <= 1:
        return arr
    mid = len(arr) // 2
    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])
    return merge(left, right)


def merge(left, right):
    l_idx = r_idx = 0
    temp = []

    while l_idx < len(left) and r_idx < len(right):
        if left[l_idx] <= right[r_idx]:
            temp.append(left[l_idx])
            l_idx += 1
        else:
            temp.append(right[r_idx])
            r_idx += 1
    temp.extend(left[l_idx:])
    temp.extend(right[r_idx:])

    return temp


result = merge_sort([])
print(result)

# def merge(st, en):
#     mid = (st + en) // 2
#     front = arr[st:mid]
#     back = arr[mid:en]
#     f_idx, b_idx = 0, 0
#
#     for i in range(st, en):
#         if b_idx == len(back):
#             temp[i] = front[f_idx]
#             f_idx += 1
#         elif f_idx == len(front):
#             temp[i] = back[b_idx]
#             b_idx += 1
#         elif front[f_idx] <= back[b_idx]:
#             temp[i] = front[f_idx]
#             f_idx += 1
#         else:
#             temp[i] = back[b_idx]
#             b_idx += 1
#
#     for i in range(st, en):
#         arr[i] = temp[i]
#
#
# def merge_sort(st, en):
#     if st == en - 1:
#         return
#     mid = (st + en) // 2
#     merge_sort(st, mid)
#     merge_sort(mid, en)
#     merge(st, en)
