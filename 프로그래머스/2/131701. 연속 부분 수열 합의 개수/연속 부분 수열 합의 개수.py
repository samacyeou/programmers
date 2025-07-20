def solution(elements):
    #아니면 미리 (원형 이니깐)>큰 리스트하나를만들어두는것도
    #걍 두번만 반복하면 되나 ?<<<

    #뭔가 중복 연산 ㅠㅣ하는방법

    mySet=set()

    l = len(elements)

    for j in range(l):
        total=0
        for k in range(l):
            total+=elements[(j+k)%l]
            mySet.add(total)   

    return  len(list(mySet))           