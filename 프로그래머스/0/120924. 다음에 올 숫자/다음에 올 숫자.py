def solution(common):
    answer = 0
    d = common[1] - common[0] 
    if d == (common[2] - common[1]):
        answer = common[-1] + d
    else:
        r = common[1] / common[0]
        answer = common[-1] * r
    return answer