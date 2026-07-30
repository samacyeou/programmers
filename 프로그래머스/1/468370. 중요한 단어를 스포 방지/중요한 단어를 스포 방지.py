def find_word_str_idx(idx, message):
    ch = message[idx]
    while(not ch.isspace()):
        idx -= 1
        if idx == -1:
            break
        assert idx > -1
        ch = message[idx]

    return idx + 1 # 공백 위치 + 1 의 인덱스를 리턴. -> 단어 시작 지점.

def find_word_end_idx(idx, message):
    ch = message[idx]
    while(not ch.isspace()):
        idx += 1
        if idx == len(message):
            break
        assert idx < len(message)
        ch = message[idx]

    return idx # 공백 위치의 인덱스를 리턴. 



def solution(message, spoiler_ranges):
    answer = 0

    # 단어별로 나누기
    words_list = message.strip().split()
    words = list(dict.fromkeys(words_list)) # 단어의 id -> 단어 // 사실상 unique 단어들의 리스트.
    word2id = {words[i]: i for i in range(len(words))} # 단어 -> 단어의 id

    # is_spoilered : 이미 한 단어라도 스포가 되었는지
        # 만약에 스포 방지 구간 외의 구간에 있다거나
        # 스포 방지 구간에 있으나 이미 앞에서 공개가 되었다거나
    is_spoilered = [False] * len(words)
    is_counted = [False] * len(words)
    # 만약 해당 단어가 카운팅 되었으면 True (앞에서 중요한 단어로 판단했는데 이후에 스포 방지 구간에 있을 경우에 -1 )

    end = 0
    # spoiler_ranges에 포함되는 단어 따로 flag 하기
    for i in range(len(spoiler_ranges) + 1): # 각 구간별 앞의 끝 구간부터 본인까지를 검사한다고 보면 될 듯.
        # 마지막 구간만 따로 처리.
        prev_end = end
        if i == len(spoiler_ranges):
            # return 1
            start = len(message)
            end = len(message)
        else:
            assert spoiler_ranges[i][0] >= 0
            assert spoiler_ranges[i][1] <= len(message)
            assert spoiler_ranges[i][0] <= spoiler_ranges[i][1]
            start = find_word_str_idx(spoiler_ranges[i][0], message)
            end = find_word_end_idx(spoiler_ranges[i][1], message)

        # assert start <= end
        # assert prev_end <= start

        out_interv_msg = message[prev_end:start]
        out_interv_words = out_interv_msg.strip().split()

        for w in out_interv_words:
            word_id = word2id.get(w)
            if not is_spoilered[word_id]: # False (not spoilered yet)
                if is_counted[word_id]: # Already counted (FT -> TF)
                    is_counted[word_id] = False
                    is_spoilered[word_id] = True
                    answer -= 1
                else: # Not yet counted (FF -> TF)
                    is_spoilered[word_id] = True


        interv_msg = message[start:end]
        interv_words = interv_msg.strip().split()

        for w in interv_words:
            word_id = word2id.get(w)
            if not is_spoilered[word_id]: # not spoilered yet
                if is_counted[word_id]: # but already counted
                    pass
                else: # not yet counted
                    is_counted[word_id] = True
                    answer += 1

    return answer
