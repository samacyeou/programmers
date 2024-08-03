import math
def solution(price):
    if price<100000:
        answer=price
    elif 100000<=price<300000:
        answer=price*0.95
    elif 300000<=price<500000:
        answer=price*0.90
    elif price>=500000:
        answer=price*0.80
    return int(answer)