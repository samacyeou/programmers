def dfs(info, n, index, cur, curList):
    if n == 0 or index == 10:
        cur[10] = n

        apeachP = 0
        lionP = 0
        arrowP = 0
        temp = [0] * 13

        for i in range(11):
            if info[i] != 0 and info[i] >= cur[i]: apeachP += 10 - i
            elif cur[i] > info[i]: lionP += 10 -i

            temp[i] = cur[i]
            arrowP += cur[i] * (10 - i)

        if(lionP > apeachP):
            temp[11] = lionP - apeachP
            temp[12] = arrowP
            curList.append(temp)

        return

    if n > info[index]:
        cur[index] = info[index] + 1
        dfs(info, n - (info[index] + 1), index + 1, cur, curList)

    cur[index] = 0
    dfs(info, n, index + 1, cur, curList)

    return
    
def solu(n, info):
    answer = []
    result = [0] * 11
    temp = [0] * 13
    maxDiff = 0
    minArrowP = 0
    idx = 0
    win = []

    dfs(info, n, 0, result, win)

    if(len(win) == 0): answer = [-1]
    else:
        for i in range(len(win)):
            temp = win[i]

            if temp[11] > maxDiff or (temp[11] == maxDiff and temp[12] < minArrowP):
                maxDiff = temp[11]
                minArrowP = temp[12]
                idx = i

        answer = win[idx][0:11]

    if n>10: return [-2]
    return answer
    
def solution(n, info):
    counterpart_score = sum((10-i) for i in range(10) if info[i])
    # 어피치의 점수의 총합
    dp = [[0,[]] for _ in range(n+1)]
    # 총 점수, 점수를 얻은 칸 위치 리스트 n은 들어간 화살 갯수
    for i in range(10):
        c = info[i]
        # 상대방이 맞춘 화살이 있다면
        if c != 0:
            for j in range(n-c):
                # 내가 점수를 얻어서 상대방의 점수가 줄어든 경우 (10-i) * 2 추가
                if (j==0 or dp[j][0]) and dp[j][0]+2*(10-i)>= dp[j+c+1][0] and 10-i not in dp[j][1]:
                    dp[j+c+1][0] = dp[j][0]+2*(10-i)
                    dp[j+c+1][1]=dp[j][1].copy()
                    dp[j+c+1][1].append(10-i)
        else:
            # 상대방이 맞춘 화살이 없어서 하나만 투자해도 점수를 얻을 수 있는 경우 (10-i) 추가
            for j in range(n):
                if (j==0 or dp[j][0]) and dp[j][0]+(10-i) >= dp[j+1][0] and 10-i not in dp[j][1]:
                    dp[j+1][0] = dp[j][0]+(10-i)
                    dp[j+1][1]=dp[j][1].copy()
                    dp[j+1][1].append(10-i)
        
    # dp = [[0,[]],[6,[6]],[18,[9]],[24,[9,6]],[34,[9,8]],[40,[9,8,6]]]
    max_comb = max(dp, key= lambda x:x[0])
    if max_comb[0] <= counterpart_score:
        return [-1]

    temp = [[1,0]]
    ans = [0]*11
    s = 0
    for num in max_comb[1]:
        ans[10-num] = info[10-num]+1
        s += info[10-num]+1

    ans[10] = n - s

    test = solu(n, info)
    
    return test