def solution(ingredient):
    answer = 0
    a = ''

    for i in ingredient:
        a += str(i)
        if a[-4:] == '1231':
            a = a[:-4]
            answer += 1
    return answer