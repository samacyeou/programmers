def solution(board, moves):
    answer = 0
    doll_list=[]
    def what_n(num):
        for k in range(len(board)):
            if(board[k][num]!=0):
                temp=board[k][num]
                board[k][num]=0
                return temp
        return -1

    def check(lst, count):
        add=0
        if count==0:
            return 0
        if lst[count]==lst[count-1]:
            add=2
            count-=2
            lst.pop()
            lst.pop()
            return add
        else:
            return 0





    count=-1
    for i in moves:
        #인형 가지고 오기
        doll=what_n(i-1)

        if(doll!=-1):            
            #인형 리스트에 넣기
            doll_list.append(doll)
            count+=1

            #인형 확인하기
            add=check(doll_list,count)           
            answer+=add
            count = len(doll_list) - 1
        else: 
            pass



    return answer