function countK(start, end, k) {
    const K = '' + k;
    let count = 0;
    
    for (let i = start; i <= end; i++) {
        const strNumber = '' + i;
        for (let char of strNumber) if (char === K) count++;
    }
    
    return count;
}

function solution(i, j, k) {
    let answer = 0;
    
    answer = countK(i, j, k);
    
    return answer;
}