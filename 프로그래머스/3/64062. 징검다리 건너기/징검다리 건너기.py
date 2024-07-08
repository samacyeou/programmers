def check(stones, mid, k):
    cnt = 0;
    for stone in stones:
        if stone - mid <= 0:
            cnt += 1;
        else:
            cnt = 0;
        if cnt >= k:
            return False;
    return True;

def solution(stones, k):
    start,end = 1,max(stones);
    answer = 0;
    while start<=end:
        mid = (start + end) // 2;
        can_go = check(stones, mid, k);
        if can_go:
            start = mid+1;
        else:
            end = mid-1;
            answer = mid;
    return answer;