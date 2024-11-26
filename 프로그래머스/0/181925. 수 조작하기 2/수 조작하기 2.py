# def solution(numLog):
#     answer =''
#     start= 0
#     dic = {'1':'w', '-1' :'s', '10':'d', '-10':'a'}
#     for idx in range(1, len(numLog)):
#             answer+= dic[str(numLog[idx] - numLog[idx-1])]
#     return answer

def solution(numLog):
    answer =''
    start= numLog[0]
    dic = {'1':'w', '-1' :'s', '10':'d', '-10':'a'}
    for n in numLog:
        if n - start!=0:
            answer+=dic[str(n - start)]
        start = n 
    return answer