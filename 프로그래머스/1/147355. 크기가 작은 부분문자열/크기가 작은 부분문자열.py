def solution(t, p):

    ls = [t[i:i+len(p)] for i in range(len(t) - len(p) + 1)]
    # i = str(int(p) + 1)
    # ls.append(i)
    # ls.sort()
    # print(i,p,ls)
    # return ls.index(i)

    answer = 0
    for st in ls:
        if int(st) <= int(p):
            answer +=1
    return answer