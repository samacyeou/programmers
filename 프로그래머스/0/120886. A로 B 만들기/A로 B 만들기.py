def solution(before, after):
    answer = 0
    before_dict=dict()
    after_dict=dict()
    for ch in before:
        before_dict[ch]=before_dict.setdefault(ch,0)+1

    for ch in after:
        after_dict[ch]=after_dict.setdefault(ch,0)+1
    if before_dict==after_dict:
        return 1
    return 0