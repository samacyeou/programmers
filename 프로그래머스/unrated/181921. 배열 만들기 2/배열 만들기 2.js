function solution(l, r) {
    let answer = [];
    const REGEX = new RegExp("^[05]+$");
    
    for (let i = l; i <= r; i++) {
        if (REGEX.test(String(i))) answer.push(i);
    }
    
    if (!answer.length) answer.push(-1);
    
    return answer;
}