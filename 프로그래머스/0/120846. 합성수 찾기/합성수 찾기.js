function countNumber(n) {
    const decimalList = [2, 3];
    let count = 0;
    let check = true;
    
    for (let i = 4; i <= n; i++) {
        for (let decimal of decimalList) {
            if (i % decimal === 0) {
                count++;
                check = false;
                break;
            }
        }
        if (check) decimalList.push(i);
        check = true;
    }
    
    return count;
}

function solution(n) {
    let answer = 0;
    
    answer = countNumber(n);
    
    return answer;
}