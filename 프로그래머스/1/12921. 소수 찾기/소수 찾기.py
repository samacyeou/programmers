import math

def isPrime(number,myList):
    if(number==3):
        return True

    for num in myList:
        if(num>math.sqrt(number)):
            return True
        if(number%num==0):
            return False
    return True

def solution(n):

    primeList=[2]

    answer = 0
    if(n==2):
        return 1
    else:
        answer+=1
        for num in range(3,n+1,2):
            #근데 소수의 배수인지 확인하려면, 이걸 또 순회해야하는거 아닌가
            #일단 이건 어쩔수없는 순회임(숫자 한번씩 확인해야하니)
            #이걸 홀수만 확인해서, 갯수줄임
            if(isPrime(num,primeList)==True):
                primeList.append(num)
                answer+=1

    return answer