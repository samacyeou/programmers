def solution(picks, minerals):

    remainPicks = picks
    groups = int(len(minerals) / 5)
    eachGroupSum = []
    sum1 = 0
    remains = len(minerals) % 5 

    sum2 = 0
    for x in picks:
        sum2 += x

    if remains != 0:
        groups += 1

    if groups - sum2 > 0 :
        minerals = minerals[0:sum2*5]

    for i in range(len(minerals)):
        if minerals[i] == 'diamond':
            sum1 += 25
        elif minerals[i] == 'iron':
            sum1 += 5
        elif minerals[i] == 'stone':
            sum1 += 1

        if i % 5 == 4 and i > 0:
            eachGroupSum.append(sum1)
            sum1 = 0

        if i % 5 != 4 and i == len(minerals) - 1 :
            eachGroupSum.append(sum1)

    indexed_list = list(enumerate(eachGroupSum))
    sorted_indexed_list = sorted(indexed_list, key=lambda x: x[1])
    original_indices = [index for index, value in sorted_indexed_list] # 원래 인덱스
    original_indices.reverse()
    print(original_indices)
    eachGroupSum.sort(reverse=True)

    fatigue = 0
    for i in range(len(eachGroupSum)):
        picks, pickaxe = getPickaxe(picks)
        print(picks, pickaxe)
        if pickaxe == 'none':
            break
        fatigue += getFatigue(original_indices[i], minerals, pickaxe)

    answer = fatigue
    return answer

def getPickaxe(picks):
    pick = ''
    if picks[0] > 0:
        picks[0] = picks[0] - 1
        pickaxe = 'diamondPA'
    elif picks[1] > 0:
        picks[1] = picks[1] - 1
        pickaxe = 'ironPA'
    elif picks[2] > 0:
        picks[2] = picks[2] - 1
        pickaxe = 'stonePA'
    else:
        pickaxe = 'none' 
    return picks, pickaxe

def getFatigue(i, minerals, pickaxe):
    fatigue = 0
    curMinerals = minerals[i*5:i*5+5]
    print(curMinerals)
    for j in range(len(curMinerals)):
        if curMinerals[j] == 'stone':
            fatigue += 1
        elif curMinerals[j] == 'iron':
            if pickaxe == 'stonePA':
                fatigue += 5
            else:
                fatigue += 1
        else:
            if pickaxe == 'stonePA':
                fatigue += 25
            elif pickaxe == 'ironPA':
                fatigue += 5
            else:
                fatigue += 1

    return fatigue   