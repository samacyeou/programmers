def solution(sides):
    answer = 0
    sides2 = sides
    sides3 = [0,0,0]
    s = sides[0] + sides[1]



    for i in range(1, s):
        sides2.append(i)              

        sides3[0]= min(sides2)
        sides3[2]= max(sides2)

        sides2.remove(max(sides2))
        sides2.remove(min(sides2))


        sides3[1]= sides2[0]



        if(sides3[2] <= sides3[0] + sides3[1] ):
            print(sides3)

            answer = answer +1
        if(sides3==[1,1,2]): return 1

        sides2.append(sides[0])
        sides2.append(sides[1])
        sides3 = [0,0,0]



    return answer