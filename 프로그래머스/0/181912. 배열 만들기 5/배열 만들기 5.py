def solution(intStrs, k, s, l):

    r = [int(n[s:s+l]) for n in intStrs]
    for n in r[:]:
        print(n)
        if n <= k:
            r.remove(n)
    return r