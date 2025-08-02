import math

def getn(j, n):
    if n == 0:
        return "0"

    s = ""
    '''
    111(3) = 3^2*1 + 3^1*1 + 3^0*1

    4(10) = 100(2)
    log2(4) = 2
    '''

    while n!=0:
        temp = n // j
        next_val = n % j
        if next_val >= 10:
            next_val = chr(ord('A') + (next_val % 10))
        s += str(next_val)
        n = temp

    return s[::-1]

def solution(n, t, m, p):    
    s = ""
    for i in range(t * m + 1):
        s += getn(n, i)
    # print(s)
    return s[p-1::m][:t]