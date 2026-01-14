from collections import defaultdict, deque
def solution(points, routes):
    bol_d = defaultdict(int)
    answer = 0
    def go(sp,ep, t):
        start_y = points[sp-1][0] - 1
        start_x = points[sp-1][1] - 1
        end_y   = points[ep-1][0] - 1
        end_x   = points[ep-1][1] - 1
        # print((start_y, start_x), (end_y, end_x))
        # bol_d[(t, start_y, start_x)] += 1    
        while start_y != end_y:
            if start_y > end_y:
                start_y -= 1
            else:
                start_y += 1
            t += 1
            # print(t, start_y, start_x)
            bol_d[(t, start_y, start_x)] += 1

        while start_x != end_x:
            if start_x > end_x:
                start_x -=1
            else:
                start_x += 1
            t +=1
            # print(t, start_y, start_x)
            bol_d[(t, start_y, start_x)] += 1

        # print((sp, ep), bol_d)
        return t

    # for j in points:
    #     bol_d[(0, j[0]-1, j[1]-1)] += 1
    for i in range(len(routes)):
        rout = deque(routes[i])
        time = 0
        st = rout.popleft()
        while rout:
            ed = rout.popleft()
            bol_d[(time, points[st-1][0]-1, points[st-1][1]-1)] += 1
            time = go(st,ed, time)

            if rout:
                st = ed
                bol_d[(time, points[st-1][0]-1, points[st-1][1]-1)] -= 1
                # rout.appendleft(ed)
    # print(bol_d)
    for i in bol_d:
        if bol_d[i] > 1:
            answer += 1
    return answer