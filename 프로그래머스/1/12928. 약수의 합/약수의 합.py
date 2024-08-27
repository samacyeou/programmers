def divisor(num):
    div = []
    sq = int(num**(1/2))
    for i in range(1, sq+1):
        if num % i == 0:
            div.append(i)
            if i*i != num:
                div.append(num//i)
    #print(div)         
    return div 


def solution(n):
    answer = 0
    div = divisor(n)
    for d in div:
        answer += d

    if n == 0:
        answer = 0

    print(0%1)
    print(0%2)

    return answer