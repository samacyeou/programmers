function consecutiveNumbers(num, total) {
    let numbers = [];
    let middle = 0;
    const zone = (num - 1) / 2;
    
    if (num % 2) {
        middle = total / num;
        for (let i = middle - zone; i <= middle + zone; i++) {
            numbers.push(i);
        }
    } else {
        middle = Math.floor(total / num);
        for (let i = middle - Math.floor(zone); i <= middle + Math.ceil(zone); i++) {
            numbers.push(i);
        }
    }
    
    return numbers;
}

function solution(num, total) {
    let answer = [];
    
    answer = consecutiveNumbers(num, total);
    
    return answer;
}