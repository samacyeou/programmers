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
        print(i)
        print(dp,"\n")
        
    print(dp)
    # dp = [[0,[]],[6,[6]],[18,[9]],[24,[9,6]],[34,[9,8]],[40,[9,8,6]]]
    max_comb = max(dp, key= lambda x:x[0])
    temp = [[30,[1]],[31,[2]]]
    print(max(temp, key=lambda x: x[0]))
    if max_comb[0] <= counterpart_score:
        return [-1]

    ans = [0]*11

    for num in max_comb[1]:
        ans[10-num] = info[10-num]+1

    ans[10] = max(0,n-sum(ans))

    return ans