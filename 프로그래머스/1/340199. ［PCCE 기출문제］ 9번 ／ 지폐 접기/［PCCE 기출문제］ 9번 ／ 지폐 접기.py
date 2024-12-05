def solution(wallet, bill):
    answer = 0
    wallet.sort()
    while True:
        bill.sort() 
        print(bill)             
        if bill[1] > wallet[1]:
            bill[1] //=2
            answer+=1
            print(answer)
        elif bill[0] > wallet[0]:
            bill[1] //=2
            answer+=1
            print(answer)
        else: break

    return answer