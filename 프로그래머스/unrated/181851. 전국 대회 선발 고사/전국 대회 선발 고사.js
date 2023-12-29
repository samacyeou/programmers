function calculate(rank, attendance) {
    let number = 0;
    let count = 3;
    let multiple = 10000;
    let array = {};
    
    for (let i = 0; i < rank.length; i++) {
        if (attendance[i]) array[rank[i]] = i;
    }
    
    for (let num in array) {
        number += multiple * array[num];
        count--;
        multiple /= 100;
        if (count === 0) break;
    }
    
    return number;
}

function solution(rank, attendance) {
    let answer = 0;
    
    answer = calculate(rank, attendance);
    
    return answer;
}