def solution(A, B):
    answer1 = 0
    answer2 = 0
    temp = A
    correct1 = False
    correct2 = False

    temp = A

    for i in range(len(A)):
        if temp != B:
            temp = A[-(i+1):] + A[:len(A)-(i+1)]
            answer2 += 1
        else:
            correct2 = True

    if correct2:
        return answer2
    else:
        return -1