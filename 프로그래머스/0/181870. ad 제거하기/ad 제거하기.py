def solution(strArr):
    for word in strArr[:]:    #strArr[:]로 바꾸면 정상 작동
        if "ad" in word:
            strArr.remove(word)
    return strArr