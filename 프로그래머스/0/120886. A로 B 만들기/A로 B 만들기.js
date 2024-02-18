function ableAToB(before, after) {
    const A = before.split('').sort();
    const B = after.split('').sort();
    let check = A.every((number, index) => number === B[index]) ? 1 : 0;
    
    return check;
}

function solution(before, after) {
    let answer = 0;
    
    answer = ableAToB(before, after);
    
    return answer;
}