def solution(bandage, health, attacks):


    n=len(attacks)
    a=attacks[n-1][0]

    s=0
    u=0
    real_health=health
    for t in range(a+1):

        if t==0:

            if t==attacks[u][0]:            
                s=0
                real_health=real_health-attacks[u][1]
                u+=1

            continue    

        if t==attacks[u][0]:            
                s=0
                real_health=real_health-attacks[u][1]
                u+=1        


        else:
            if real_health<= health:
                real_health=real_health+bandage[1]
                s+=1

                if real_health>health:
                    real_health=health

                if s==bandage[0]:
                    real_health=real_health+bandage[2]
                    s=0
                    if real_health>health:
                        real_health=health


        if real_health<=0:
            real_health=-1
            break


    answer =real_health
    return answer
