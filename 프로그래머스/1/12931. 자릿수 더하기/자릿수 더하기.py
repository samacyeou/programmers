def solution(n):
    answer = 0
    quotient, remainder = 0, 0

    # [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    while n >= 10:        
        quotient, remainder = divmod(n, 10)   
        n = quotient
        answer += remainder

    answer += n        

    return answer