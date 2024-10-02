def solution(n1, d1, n2, d2):
    
    for i in range(99999999999999999999):
        if int(n1 * (i+1) / d1  + n2 * (i+1)/ d2) == n1 * (i+1) / d1 + n2 * (i+1) / d2:

            return [int(n1 * (i+1) / d1 + n2 * (i+1) / d2), (i+1)]