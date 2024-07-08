from collections import defaultdict;
def solution(stones, k):
    def continuity(stones,mid):
        ct = 0;
        for stone in stones:
            if (stone - mid) <= 0:
                ct += 1;
            else:
                ct = 0;
            if ct>=k:
                break;
        return ct;
    answer = 0
    left, right = 1, max(stones);
    while left <= right:
        mid = (left + right)//2;
        ct = continuity(stones,mid);
        if ct < k:
            left = mid + 1;
        else:
            answer = mid;
            right = mid-1;
    return answer