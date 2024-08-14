def solution(data, ext, val_ext, sort_by):
    control = {'code': 0, 'date': 1, 'maximum': 2, 'remain': 3}
    i = control[ext]
    j = control[sort_by]
    fdata = sorted(
        (item for item in data if item[i] <= val_ext),
        key=lambda x: x[j]
    )
    return fdata
