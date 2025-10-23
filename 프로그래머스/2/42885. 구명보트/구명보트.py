def solution(people, limit):

    people.sort()
    n = len(people)
    res = 0

    l, r = 0, n-1
    while l <= r:
        if people[l] + people[r] <= limit: l += 1

        r -= 1    
        res += 1

    return res
