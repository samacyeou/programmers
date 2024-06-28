import heapq
def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    while scoville[0] <K:
        answer +=1 
        lowSpciy =heapq.heappop(scoville)
        middleLowSpciy = heapq.heappop(scoville)
        data = lowSpciy + (middleLowSpciy * 2)
        heapq.heappush(scoville ,data)
        if len(scoville) < 2 and scoville[0] <K:
            answer = -1 
            break  
        if scoville[0] > K:
            break
    return answer