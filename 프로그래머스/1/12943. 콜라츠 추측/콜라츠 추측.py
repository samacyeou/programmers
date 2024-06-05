def solution(num):
    tried = 0
    result = 0
    while True:
        if tried ==0 and  num ==1:
            result ==0
            break
        tried += 1
        if num % 2 ==0:
            num = num/2
        elif num % 2 == 1:
            num = num*3
            num = num+1

        if num ==1:
            result = tried
            break

        if tried > 500:
            result = -1
            break
    answer = result
    return answer