function solution(a, b, c, d) {
    let answer = 0;
    const count = new Set([a, b, c, d]);
    const array = new Array(7);
    
    array.fill(0);
    
    array[a]++;
    array[b]++;
    array[c]++;
    array[d]++;
    
    const three = array.indexOf(3);
    const twof = array.indexOf(2);
    const twol = array.lastIndexOf(2);
    const onef = array.indexOf(1);
    const onel = array.lastIndexOf(1);
    
    switch(count.size) {
        case 1 : answer = 1111 * a; break;
        case 2 :
            if (three !== -1) answer = (10 * three + onef) ** 2;
            else answer = (twof + twol) * Math.abs(twof - twol);
            break;
        case 3 : answer = onef * onel; break;
        case 4 : answer = Math.min(a, b, c, d); break;
    }
    return answer;
}