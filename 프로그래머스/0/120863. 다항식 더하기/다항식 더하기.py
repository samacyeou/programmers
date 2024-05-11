def solution(polynomial):
    a = polynomial.replace('+ ','')
    x = ''
    num = []
    for i in a.split():
        if 'x' in i and 'x' != i:
            x += 'x'*int(i.replace('x',''))
        elif 'x' == i:
            x += 'x'
        elif i.isdigit():
            num.append(int(i))
    if num == []:
        return '{}x'.format(x.count('x')) if x.count('x') != 1 else 'x'
    elif x == '':
        return '{}'.format(sum(num))
    else:
        return '{}x + {}'.format(x.count('x'), sum(num)) if x.count('x') != 1 else 'x + {}'.format(sum(num))