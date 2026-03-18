def solution(n_str):
    # answer = str(int(n_str))
    answer = 0

    print(len(set(n_str)) != 1)

    if 1 <= len(n_str) <= 100:
        answer = str(int(n_str))

    return answer