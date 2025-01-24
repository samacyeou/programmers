def solution(n, lost, reserve):
    # 중복 제거: 여벌이 있는 학생이 도난당한 경우, 본인이 사용하도록 먼저 처리
    reserve_set = set(reserve)
    lost_set = set(lost)
    common = reserve_set & lost_set  # 교집합
    reserve_set -= common
    lost_set -= common

    # 빌려줄 수 있는 학생을 처리
    for value in sorted(reserve_set):
        if value - 1 in lost_set:  # 왼쪽 학생에게 빌려줌
            lost_set.remove(value - 1)
        elif value + 1 in lost_set:  # 오른쪽 학생에게 빌려줌
            lost_set.remove(value + 1)

    # 체육 수업에 참여할 수 있는 학생 수 계산
    return n - len(lost_set)