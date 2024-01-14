function countLine(sides) {
    const smallNumber = Math.min(...sides);
    const count = smallNumber * 2 - 1;
    
    return count;
}

function solution(sides) {
    let answer = 0;
    
    answer = countLine(sides);
    
    return answer;
}