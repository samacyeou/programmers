def solution(i, j, k):
    answer = 0
    mid=''
    for num in range(i,j+1):
        mid+=str(num)
    answer=len(mid)-len(mid.replace(str(k),''))
    # print(help(str))
    return answer