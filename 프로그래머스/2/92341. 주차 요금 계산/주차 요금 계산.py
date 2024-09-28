import math
def solution(fees, records):
    answer = []
    carlist = []
    nameofcars = []
    inandout = {}
    timeofcars = []
    numberofcar = {}
    for i in records:
        a,b,c = i.split()
        mim,sce = map(int,a.split(':'))
        a = mim*60+sce
        carlist.append([a,b])
    for i in carlist:
        if i[1] not in nameofcars:
            nameofcars.append(i[1])
            inandout[i[1]] = i[0]
        else:
            timeofcars.append([i[1],abs(i[0]-inandout[i[1]])])
            nameofcars.remove(i[1])
    for i in nameofcars:
        timeofcars.append([i,abs(inandout[i]-(23*60+59))])
        # nameofcars.remove(i)
    for i in timeofcars:
        if numberofcar.get(i[0])==None:
            numberofcar[i[0]] = i[1]
        else:
            numberofcar[i[0]] = numberofcar.get(i[0])+i[1]
    nameofcars = list(numberofcar.keys())
    nameofcars.sort()
    for i in nameofcars:
        if numberofcar[i]<fees[0]:
            answer.append(fees[1])
        else:
            k = ((numberofcar[i] - fees[0]) // fees[2]) * fees[3] + fees[1]
            if (numberofcar[i] - fees[0]) % fees[2] != 0:
                k += fees[3]
            answer.append(k)
    return answer