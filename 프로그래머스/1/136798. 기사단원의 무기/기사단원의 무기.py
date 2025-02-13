import math
def solution(number, limit, power):
    getSum=0
    box2=[]

    for knightNum in range(1,number+1):
        dict2={}

        result=0
        #시작지점>굳이 연산할필요없는얘>너무 오래걸릴것같
        #사전 ?
        if   knightNum==1:
            dict2={}
            numDiv=1
            result+=numDiv

        elif   knightNum==2:
            dict2={1,2}
            numDiv=2
            result+=numDiv

        else:
            for num in range(1,knightNum+1):
                if num>=math.sqrt(knightNum):
                    break

                if knightNum%num==0:
                    #result+=1
                    dict2[num]=knightNum//num

        if knightNum!=1 and knightNum!=2:
            numDiv=len(dict2)*2

            if knightNum==(int)(math.sqrt(knightNum))**2:

                numDiv+=1

            result+=numDiv





        if result>  limit:
            result=power
        getSum+=result    

        box2.append(numDiv)




    return getSum