function writeNumber(number) {
    let count = number;
    let showNumber = 0;
    
    while(count > 0) {
        showNumber++;
        
        if (showNumber % 3 === 0 || String(showNumber).indexOf("3") !== -1) continue;
        else count--;
    }
    
    return showNumber;
}

function solution(n) {
    let answer = 0;
    
    answer = writeNumber(n);
    
    return answer;
}