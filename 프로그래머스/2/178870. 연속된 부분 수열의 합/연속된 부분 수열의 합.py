def solution(sequence, k):

    n = len(sequence)
    dist = n+1
    res = None
    runningSum = [0]*(n+1)
    runningSum[1] = sequence[0]

    for i in range(n):
        runningSum[i+1] = runningSum[i]+sequence[i]
    l, r = 0, 1    

    while r < n+1:
        if runningSum[r]-runningSum[l] == k:
            if r-l < dist:
                dist = r-l
                res = [l, r-1]
            l += 1
            r += 1

        elif runningSum[r]-runningSum[l] > k: l += 1
        else: r += 1

    return res