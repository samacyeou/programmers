def solution(participant, completion):

    participant.sort()
    completion.sort()
    answer = participant[0]
    for i in range(len(completion)):
        if participant[i] != completion[i]:
            answer = participant[i]
            break
        else :
            answer = participant[-1]

    return answer