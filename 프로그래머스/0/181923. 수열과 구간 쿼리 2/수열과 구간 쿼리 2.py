def solution(arr, queries):
    answer = []
    for s, e, k in queries:
        l = []
        for i in range(s,e+1):
            if arr[i] > k:
                l.append(arr[i])
        if l:
            answer.append(min(l))
        else:
            answer.append(-1)

    return answer