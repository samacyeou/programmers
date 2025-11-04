def solution(queue1, queue2):

    from collections import deque 

    sum1, sum2 = sum(queue1), sum(queue2)
    res = 0

    if sum1 == sum2: return res
    if (sum1 + sum2) % 2 == 1: return -1

    queue1 = deque(queue1)
    queue2 = deque(queue2)

    if sum1 < sum2:
        queue1, queue2 = queue2, queue1
        sum1, sum2 = sum2, sum1        

    q1 = queue1.copy()
    qSum = sum1
    l = len(queue1) * 3 - 3
    count = 0

    while sum1 != sum2:

        item = queue1.popleft()
        queue2.append(item)
        sum1 -= item
        sum2 += item
        res += 1        

        if sum2 > sum1:
            queue1, queue2 = queue2, queue1
            sum1, sum2 = sum2, sum1

        count += 1
        if count == l: break
    if sum1 != sum2: return -1

    return res