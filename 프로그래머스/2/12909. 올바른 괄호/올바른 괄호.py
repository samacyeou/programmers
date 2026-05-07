def solution(s):
    answer = True

    cnt=0
    if s[0]==')' or s[-1]=='(':
        answer=False
    else:
        for i in range(len(s)):
            if cnt<0:
                break
            elif s[i]=='(':
                cnt+=1
            elif s[i]==')':
                cnt-=1
    
    if cnt!=0:
        answer=False
    return answer