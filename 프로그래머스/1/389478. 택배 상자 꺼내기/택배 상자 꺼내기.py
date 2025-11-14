def solution(n, w, num):
    answer = 0
    arr = []
    for i in range(1, (n//w)*w+1, w):
        if (i // w)%2 == 0:
            arr.append([j for j in range(i, i+w)])
        else:
            arr.append([j for j in range(i+w-1,i-1,-1)])
    if n%w != 0:
        if (n//w)%2 == 0:
            arr.append([j for j in range((n//w)*w, n+1)])
            arr[n//w].extend([0 for j in range(w-n%w)])
        else:
            arr.append([0 for j in range(w-n%w)])
            arr[n//w].extend([j for j in range(n, (n//w)*w, -1)])

    found = False
    for aa in reversed(arr):
        answer += 1
        for i, a in enumerate(aa):                
            if a == num:
                found = True
                break
        if found:
            if arr[-1][i] == 0:
                answer -= 1
            break

    if found == False:
        answer = 0

    return answer