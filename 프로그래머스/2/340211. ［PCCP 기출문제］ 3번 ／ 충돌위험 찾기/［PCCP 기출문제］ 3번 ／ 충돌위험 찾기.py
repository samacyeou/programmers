from collections import Counter
def route_list(start_r,start_c, end_r,end_c, route_lst):
    while not(start_r==end_r and start_c==end_c):

        if start_r<end_r:
            start_r+=1
            route_lst.append((start_r,start_c))
            continue

        if start_r>end_r:
            start_r-=1
            route_lst.append((start_r,start_c))
            continue
        if start_c<end_c:
            start_c+=1
            route_lst.append((start_r,start_c))
            continue
        if start_c>end_c:
            start_c-=1
            route_lst.append((start_r,start_c))
            continue

    return route_lst      
def solution(points, routes):

    answer=0
    robot=[]
    for route in routes:
        route_lst=[]
        for i in range(len(route)-1):
            start = points[route[i]-1]
            end = points[route[i+1]-1]
            start_r = start[0]
            start_c = start[1]
            end_r = end[0]
            end_c = end[1]
            if i==0:
                route_lst.append((start_r,start_c))
            route_list(start_r,start_c, end_r,end_c,route_lst )

        robot.append(route_lst)
    max_ = max([len(r) for r in robot])    
    for i in range(max_):
        lst=[]
        for r in range(len(routes)):
            if len(robot[r])<=i:
                continue
            else:
                lst.append(robot[r][i])

        crash_dash = Counter(lst)
        for k,v in crash_dash.items():
            if v>1:
                answer+=1


    return answer