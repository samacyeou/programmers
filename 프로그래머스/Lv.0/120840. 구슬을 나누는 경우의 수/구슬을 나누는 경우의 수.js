function countCase(balls, share) {
    let count = 1;
    
    for (let i = 0; i < share; i++) {
        count *= (balls - i) / (i + 1);
    }
    
    count = Math.round(count);
    
    return count;
}

function solution(balls, share) {
    let answer = 0;
    
    answer = countCase(balls, share);
    
    return answer;
}