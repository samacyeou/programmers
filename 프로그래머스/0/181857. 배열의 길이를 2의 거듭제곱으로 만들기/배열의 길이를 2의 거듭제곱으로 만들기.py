def solution(arr):
    a = [2**i for i in range(1,11)]
    if len(arr) not in a and len(arr) != 1:
        while len(arr) not in a:
            arr.append(0)
    return arr