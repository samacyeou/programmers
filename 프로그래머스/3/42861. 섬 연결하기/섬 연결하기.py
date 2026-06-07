def solution(n, costs):
    answer = 0
    new_costs = [[e, u, v] for u, v, e in costs]
    new_costs.sort(reverse=True)
    # print(f'{new_costs = }')
    visited = set()
    cost = 0
    rest = []
    while new_costs:
        e, u, v = new_costs.pop()
        if not visited:
            visited.update({u, v})
            cost += e
        elif u in visited and v in visited:
            continue
        elif u in visited:
            visited.add(v)
            cost += e
            new_costs.extend(rest)
            rest.clear()
        elif v in visited:
            visited.add(u)
            cost += e
            new_costs.extend(rest)
            rest.clear()
        else:
            rest.append([e, u, v])
        # print(f'{rest = }, {cost = }, {visited = }')
    # print(f'{visited = }')
    answer = cost
    return answer