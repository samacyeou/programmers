INF = 100 * 1000 + 1
def solution(temperature, t1, t2, a, b, onboard):

    temperature += 10
    t1 += 10
    t2 += 10
     # 온도 -> 0 ~ 50 -> 51개

    n_time = len(onboard)



    dp = [[INF]*52 for _ in range(n_time)] # dp[time][temperature] -> time에 temp를 유지하기 위한 최소 비용

    dp[0][temperature] = 0 

    for time in range(1, n_time):
        if onboard[time]:
            max_temp = t2
            min_temp = t1
        else:
            max_temp = max(t2, temperature)
            min_temp = min(t1, temperature)

        for temp in range(min_temp, max_temp+1):
            if temperature < t1:  # 온도를 올릴때는 a, time!=temp이고 유지할때는 b, 내릴때는 0, time=temp이고 유지할때는 0
                if temp != temperature:
                    dp[time][temp] = min(dp[time-1][temp-1] + a, dp[time-1][temp] + b, dp[time-1][temp+1])
                else:
                    dp[time][temp] = min(dp[time-1][temp], dp[time-1][temp+1])
            else:                 # 온도를 올릴때는 0, time!=temp이고 유지할때는 b, 내릴때는 a, time=temp이고 유지할때는 0
                if temp != temperature:
                    dp[time][temp] = min(dp[time-1][temp-1], dp[time-1][temp] + b, dp[time-1][temp+1] + a)
                else:
                    dp[time][temp] = min(dp[time-1][temp-1], dp[time-1][temp])

    return min(dp[n_time-1])