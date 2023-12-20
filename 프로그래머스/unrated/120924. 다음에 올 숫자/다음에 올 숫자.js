function nextNumber(common) {
    let next = 0;
    const lastIndex = common.length - 1;
    
    if (common[1] - common[0] === common[2] - common[1]) {
        next = common[lastIndex] * 2 - common[lastIndex-1];
    } else {
        next = common[lastIndex] ** 2 / common[lastIndex-1];
    }
    
    return next;
}

function solution(common) {
    let answer = 0;
    
    answer = nextNumber(common);
    
    return answer;
}