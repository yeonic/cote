ex = [10, 2, -1, 9, 4, -20, -23, 5, 23, 30]


#
# def quick_sort(arr, st, en):
#     if en <= st + 1:
#         return
#     pivot = st
#     l = st + 1
#     r = en - 1
#
#     while True:
#         while l <= r and arr[pivot] >= arr[l]:
#             l += 1
#         while l <= r and arr[pivot] <= arr[r]:
#             r -= 1
#         if l > r:
#             break
#         arr[l], arr[r] = arr[r], arr[l]
#
#     arr[pivot], arr[r] = arr[r], arr[pivot]
#     pivot = r
#
#     quick_sort(arr, st, pivot)
#     quick_sort(arr, pivot + 1, en)

def partition(arr, st, en):
    pivot, l, r = st, st + 1, en - 1

    while True:
        while l <= r and arr[l] <= arr[pivot]:
            l += 1
        while l <= r and arr[pivot] <= arr[r]:
            r -= 1
        if l > r:
            break
        arr[l], arr[r] = arr[r], arr[l]

    arr[pivot], arr[r] = arr[r], arr[pivot]
    return r


def quick_sort(arr, st, en):
    if en - st <= 1:
        return

    pivot = partition(arr, st, en)
    quick_sort(arr, st, pivot)
    quick_sort(arr, pivot + 1, en)


quick_sort(ex, 0, len(ex))
print(ex)
