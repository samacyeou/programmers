def solution(name):

    l = len(name)
    name = list(name)
    cnt = 0
    max_A, cont_A = 0, 0
    for i in name:
        if i != "A":
            cnt += min(abs(ord("A") - ord(i)), # A에서 가는법
                       abs(ord("Z") - ord(i))+1)  # Z에서 가는법
            if cont_A > 0:
                max_A = max(max_A, cont_A)
                cont_A = 0
        else:
            cont_A += 1

    if cont_A > 0:
        max_A = max(max_A, cont_A)
        cont_A = 0
        
    min_move = l-1
    for i in range(l-1, -1, -1): # 그냥가는경우
        if name[i] == "A":
            continue
        min_move = min(l-1, i)
        break

    cont_A = ["A"]*max_A
    A_pos = 0
    for i in range(l):
        if name[i:i+max_A] == cont_A:
            A_pos = i
            break
    f, b = A_pos-1 if A_pos>0 else 0, l-(A_pos+max_A) # front, back len of not A
    min_move = min(min_move, min(2*f+b, f+2*b))

    answer = cnt+min_move
    return answer