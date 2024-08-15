def solution(s):
    answer = ''
    index = 0
    for spell in s:
        if spell == ' ':
            answer += ' '
            index = 0
        else:
            if index % 2 == 0:
                answer += spell.upper()
            else:
                answer += spell.lower()
            index += 1
    return answer