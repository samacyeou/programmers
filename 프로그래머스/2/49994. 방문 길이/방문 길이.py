command = {"U":[0, 1], "D":[0, -1], "R":[1, 0], "L":[-1, 0]}

def solution(dirs):
    answer = 0
    comb = set()
    x, y = 0, 0 # (0, 0)에서 시작

    for c in dirs: # 명령어 실행
        dx, dy = command[c] # 이동할 좌표 값

        if(x+dx < -5 or y+dy < -5) or (x+dx > 5 or y+dy > 5): # 좌표평면 넘어서면 이동 불가
            continue

        # 이동한 길을 나타내는 좌표 쌍 저장
        current_path = (x, y, x + dx, y + dy)
        reverse_path = (x + dx, y + dy, x, y)

        if (current_path not in comb) and (reverse_path not in comb):  # 이미 갔던 길이 아니면
            answer += 1  # 신규로 간 길이니 +1

        x, y = x + dx, y + dy  # 항상 길 이동]
        comb.add(current_path)  # 새로운 길 저장

    return answer