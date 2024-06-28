def solution(survey, choices):
    answer = ''
    dic = {'R' : 0, 'T' : 0,
          'C' : 0, 'F' : 0,
          'J' : 0, 'M' : 0,
          'A' : 0, 'N' : 0}
    def score(s,c):
        if c in [1,2,3]:
            dic[s[0]] += abs(c-4)
        elif c in [5,6,7]:
            dic[s[1]] += (c-4)
        return dic

    for i in range(len(survey)):
        score(survey[i], choices[i])

    def check(a,b):
        if dic[a] >= dic[b]:
            return a
        elif dic[b] > dic[a]:
            return b
    for a,b in [('R','T'), ('C','F'), ('J','M'), ('A','N')]:
        answer += check(a,b)
    return answer