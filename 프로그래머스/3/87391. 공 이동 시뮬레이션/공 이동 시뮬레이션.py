def solution(n, m, x, y, queries):
    answer = 0
    start = [x,y] # 행렬
    # 상하좌우 벽까지 거리 음수는 벽을 뚫는다. 양수이면 그냥 불가
    dx_use = [False,False] # 상하
    dy_use = [False,False] # 좌우
    dx = [0,0] # 상하
    dy = [0,0] # 좌우

    for i in range(len(queries)-1,-1,-1):
        query = queries[i]
        if query[0] == 0:
            start[1] += query[1]
        elif query[0] == 1:
            start[1] -= query[1]
        elif query[0] == 2:
            start[0] += query[1]
        else:
            start[0] -= query[1]

        if start[0] < 0:
            start[0] = 0
        elif start[0] >= n:
            start[0] = n-1
        if start[1] < 0:
            start[1] = 0
        elif start[1] >= m:
            start[1] = m-1

    org_start = [start[0], start[1]]

    for query in queries:
        if query[0] == 0:
            start[1] -= query[1]
        elif query[0] == 1:
            start[1] += query[1]
        elif query[0] == 2:
            start[0] -= query[1]
        else:
            start[0] += query[1]

        if start[0] < 0:
            dx[0] += -start[0]
            start[0] = 0
        elif start[0] >= n:
            dx[1] += start[0]-(n-1)
            start[0] = n-1
        if start[1] < 0:
            dy[0] += -start[1]
            start[1] = 0
        elif start[1] >= m:
            dy[1] += start[1]-(m-1)
            start[1] = m-1

        check_use_dx_dy(start, dx_use, dy_use, n, m)

    # test case 33,34
    if [x,y] != start:
        return 0

    # 상,하,좌,우 될 수 있는 면적 너비를 구한다. - 될까?  
    x_diff = 1
    y_diff = 1

    if dx_use[0] and dx_use[1]:
        x_diff = n
    elif dx_use[0]:
        x_diff = org_start[0] + 1 + dx[0]
    elif dx_use[1]:
        x_diff = n - org_start[0] + dx[1]
    if dy_use[0] and dy_use[1]:
        y_diff = m
    elif dy_use[0]:
        y_diff = org_start[1] + 1 + dy[0]
    elif dy_use[1]:
        y_diff = m - org_start[1] + dy[1]    

    if x_diff > n:
        x_diff = n
    if y_diff > m:
        y_diff = m
    return x_diff * y_diff


def check_use_dx_dy(start, dx_use, dy_use, n, m):
    if start[0] <= 0:
        dx_use[0] = True
    if start[0] >= n-1:
        dx_use[1] = True
    if start[1] <= 0:
        dy_use[0] = True
    if start[1] >= m-1:
        dy_use[1] = True