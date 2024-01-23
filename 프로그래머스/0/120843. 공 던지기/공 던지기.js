function throwNumber(numbers, k) {
    const turn = (k * 2 - 2) % numbers.length;
    
    return numbers[turn];
}

function solution(numbers, k) {
    let answer = 0;
    
    answer = throwNumber(numbers, k);

    return answer;
}