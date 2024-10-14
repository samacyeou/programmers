def solution(sequence, k):
    answer = []
    startIdx=len(sequence)-1
    endIdx=len(sequence)-1
    temp=0

    while True:
        if temp > k:
            temp -= sequence[endIdx]
            # print(startIdx, endIdx, temp)
            if temp == k:
                break
            endIdx-=1
        elif temp < k:
            temp += sequence[startIdx]
            # print(startIdx, endIdx, temp)
            if temp == k:
                break
            startIdx-=1
    while startIdx > 0 and (sequence[startIdx] == sequence[endIdx]) and (sequence[startIdx] == sequence[startIdx-1]) :
        startIdx-=1
        endIdx-=1
        # print(startIdx, endIdx)

    return [startIdx,endIdx]