def solution(points, routes):
    result = []
    length = len(routes)
    robots_place = []

    for i in range(length):
        robots_place.append(points[routes[i][0] - 1].copy())
        routes[i].pop(0)

    for i in range(length):
        temp = [robots_place[i].copy()]
        while routes[i]:
            target = points[routes[i][0] - 1]
            if robots_place[i] == target:
                routes[i].pop(0)
            else:
                if robots_place[i][0] < target[0]:
                    robots_place[i][0] += 1
                elif robots_place[i][0] > target[0]:
                    robots_place[i][0] -= 1
                elif robots_place[i][1] < target[1]:
                    robots_place[i][1] += 1
                elif robots_place[i][1] > target[1]:
                    robots_place[i][1] -= 1

                temp.append(robots_place[i].copy())
        result.append(temp)

    max_length = max(len(subarray) for subarray in result)
    for i in range(len(result)):
        gap = max_length - len(result[i])
        while gap:
            result[i].append([0, 0])
            gap -= 1

    transposed = [
        [item for item in group if item != [0, 0]]
        for group in zip(*result)
    ]

    count = 0

    for i in transposed:
        for j in i[:]:
            temp = j
            len_temp = len(i)
            while j in i:
                i.remove(temp)
            if len_temp - len(i) > 1:
                count += 1
    return count