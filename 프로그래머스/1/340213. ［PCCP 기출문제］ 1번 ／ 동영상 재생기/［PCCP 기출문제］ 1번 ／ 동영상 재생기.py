def solution(video_len, pos, op_start, op_end, commands):
    answer = ''
    def str_to_time(s):
        mm, ss = s.split(':')
        return int(mm) * 60 + int(ss)

    def time_to_str(t):
        m = t // 60
        if m < 10:
            m = "0" + str(m)
        else:
            m = str(m)
        s = t % 60
        if s < 10:
            s = "0" + str(s)
        else:
            s = str(s)
        return m + ':' + s

    video_len, pos = str_to_time(video_len), str_to_time(pos)
    op_start, op_end = str_to_time(op_start), str_to_time(op_end)
    
    if op_start <= pos <= op_end:
        pos = op_end
        
    for command in commands:
        if op_start <= pos <= op_end:
                pos = op_end
        if command == 'prev':
            if pos < 10:
                pos = 0
                continue
            pos -= 10
            if op_start <= pos <= op_end:
                pos = op_end
        else:
            if pos + 10 >= video_len:
                pos = video_len
                continue
            pos += 10
            if op_start <= pos <= op_end:
                pos = op_end
                
    return time_to_str(pos)