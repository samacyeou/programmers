from collections import deque as dq

def solution(n, lost, reserve):
    lost.sort()
    reserve.sort()
    for l in lost[:]:
        if l in reserve:
            lost.remove(l)
            reserve.remove(l)
    # lost = dq(lost)
    # reserve = dq(reserve)
    il = 0
    ir = 0
    answer = n
    while ir < len(reserve) and il < len(lost):
        # print('ia,ib,lost,reserve')
        # print(ia,ib,lost,reserve)
        if reserve[ir] < lost[il]-1:
            ir += 1
        elif lost[il]-1 <= reserve[ir] <= lost[il]+1:
            lost.pop(il)
            reserve.pop(ir)
        else: # lost[il]+1 < reserve[ir]
            il += 1
        if not lost:
            return answer
        if not reserve:
            return answer - len(lost)
        # print(lost)
    if lost:
        answer -= len(lost)
    return answer