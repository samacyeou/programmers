def solution(numbers, hand):
    d = {0:[4,2] ,1:[1,1] ,2:[1,2] ,3:[1,3] ,4:[2,1] ,5:[2,2] ,6:[2,3] ,7:[3,1] ,8:[3,2] ,9:[3,3]}
    b = ''
    left = [4,1]
    right = [4,3]

    for i in numbers:
        if i in (1,4,7):
            b += 'L'
            left = d[i]
        elif i in (3,6,9):
            b += 'R'
            right = d[i]
        else:
            l_move = abs(left[0]-d[i][0]) + abs(left[1]-d[i][1])
            r_move = abs(right[0]-d[i][0]) + abs(right[1]-d[i][1])
            if l_move > r_move:
                b += 'R'
                right = d[i]
            elif l_move < r_move:
                b += 'L'
                left = d[i]
            else:
                if hand == 'right':
                    b += 'R'
                    right = d[i]
                else:
                    b += 'L'
                    left = d[i]
    return b