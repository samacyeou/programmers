def solution(strArr):
    answer = 0
    max_length = 1
    temp = []

    strArr.sort(key=len)

    max_length = len(strArr[-1])

    for i in strArr:
        temp.append(len(i))
        
    for i in range(max_length+1):
        if answer <= temp.count(i):
            answer = temp.count(i)


    return answer