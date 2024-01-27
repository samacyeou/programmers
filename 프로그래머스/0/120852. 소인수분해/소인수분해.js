function calculateFactorization(n) {
    const factorization = [];
    let num = 2;
    while(n > 1) {
        if (n % num === 0) {
            factorization.push(num);
            while(n % num === 0) n /= num;
        }
        num++;
    }
    
    return factorization;
}

function solution(n) {
    let answer = [];
    
    answer = calculateFactorization(n);
    
    return answer;
}