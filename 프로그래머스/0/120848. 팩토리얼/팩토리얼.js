function findFactorial(n) {
    let factorial = 1;
    
    while(true) {
        n /= factorial;
        factorial++;
        if (n < factorial) {
            factorial--;
            break;        
        }
    }
    
    return factorial;
}

function solution(n) {
    let answer = 0;
    
    answer = findFactorial(n);
    
    return answer;
}