from collections import deque

def solution(order):
    answer = 0
    order = deque(order)
    sub = []

    for current in range(1, len(order) + 1):
        if len(sub) >= 1:
            if sub[-1] == order[0]:
                order.popleft()
                sub.pop()
                answer += 1

        if current == order[0]:
            order.popleft()
            answer += 1
        else:
            sub.append(current)

    while sub: 
        if not sub.pop() == order.popleft():
            break
        answer += 1
    return answer