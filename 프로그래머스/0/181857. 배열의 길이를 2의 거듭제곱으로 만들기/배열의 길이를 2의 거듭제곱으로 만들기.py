def solution(arr):
    invol2 = [2 ** i for i in range(0,11)]
    num = 0
    for i in invol2:
        if len(arr) <= i:
            num = i
            break
    arr.extend([0] * (num - len(arr)))
    return arr