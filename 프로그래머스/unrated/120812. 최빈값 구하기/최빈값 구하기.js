function mostFrequentValue(array) {
    let countNumber = {};
    let same = false;
    let current = "-1";
    
    countNumber[current] = -1;
    
    for (let i of array) {
        if (String(i) in countNumber) countNumber[`${i}`]++;
        else countNumber[`${i}`] = 1;
    }
    
    for (let key in countNumber) {
        if (countNumber[current] < countNumber[key]) {
            current = key;
            same = false;
        } else if (countNumber[current] === countNumber[key]) same = true;
    }
    
    if (same) current = -1;
    
    return +current;
}

function solution(array) {
    let answer = 0;
    
    answer = mostFrequentValue(array);
    
    return answer;
}