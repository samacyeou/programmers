def divisor(num):
    temp = 0
    for i in range(2, int(num**(1/2))+1):
        if num % i == 0:
            #temp.append(i)
            temp += 2
            break
    # print(temp)
    return temp


def solution(n):
    answer = 0
    for i in range(2, n+1):
        temp = divisor(i)
        if temp != 2:
            #answer.append(i) 
            answer += 1 

    return answer