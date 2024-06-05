def solution(arr):
    answer = []
    a = min(arr)
    for i in range(len(arr)):
        if len(arr) == 1:
            answer.append(-1)
            break
        if arr[i] == a:
            continue
        answer.append(arr[i])
    return answer