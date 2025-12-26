def tree(n, appeach_info, ryan_info, tree_node):

    if n < 0:
        return -1

    if n == 0:
        appeach_score, ryan_score = 0, 0
        for i in range(len(appeach_info)):
            if appeach_info[i] < ryan_info[i] :
                ryan_score += (10 - i)
            else:
                if appeach_info[i] != 0:
                    appeach_score += (10 - i)
        if ryan_score > appeach_score:
            # print(f"{ryan_score} : {ryan_info} / {appeach_score}")
            return (ryan_score - appeach_score, ryan_info[:])
        else:
            return -1

    else:
        ans = []
        for i in range(len(appeach_info)):
            if tree_node[i]:
                tree_node[i] = False
                ryan_info[i] += (appeach_info[i] + 1)
                n -= (appeach_info[i] + 1)

                a = tree(n, appeach_info, ryan_info, tree_node)

                tree_node[i] = True
                ryan_info[i] -= (appeach_info[i] + 1)
                n += (appeach_info[i] + 1)

                if a != -1:
                    ans.append(a)

        # 모두 0점에 꽂히는 케이스 추가
        a = ryan_info[:]
        a[-1] += n
        appeach_score, ryan_score = 0, 0
        for i in range(len(appeach_info)):
            if appeach_info[i] < a[i] :
                ryan_score += (10 - i)
            else:
                if appeach_info[i] != 0:
                    appeach_score += (10 - i)
        if ryan_score > appeach_score:
            ans.append((ryan_score - appeach_score, a))

        ans.sort(key= lambda x : (x[0], tuple(reversed(x[1]))))
        if ans:
            return ans[-1]
        else:
            return -1



def solution(n, appeach_info):
    # 변수 설정
    ryan_info = [0 for _ in range(len(appeach_info))]
    tree_node = [True for _ in range(len(appeach_info))]

    # 트리 진입
    a = tree(n, appeach_info, ryan_info, tree_node)

    # 결과 도출
    if a == -1:
        return [-1]
    else:
        return a[1]