def solution(mats, park):
    answer = -1
    blank=0
    park_column=len(park);
    park_row=len(park[0]);
    mats.sort()
    for dotjari in mats:
        for i in range(park_column-dotjari+1):
            for j in range(park_row-dotjari+1):
                
                if park[i][j]=="-1": 
                    blank=1
                    for m in range(dotjari):
                          for n in range(dotjari):
                                if park[i+m][j+n]!="-1": blank=0
                if blank==1: 
                    answer=dotjari
                    blank=0




    return answer