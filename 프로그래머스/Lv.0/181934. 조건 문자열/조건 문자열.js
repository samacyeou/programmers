function compare(ineq, eq, n, m) {
    let answer;
    if (ineq === ">") {
        if (eq === "=") answer = n >= m;
        else answer = n > m;
    } else {
        if (eq === "=") answer = n <= m;
        else answer = n < m;
    }
    
    return +answer;
}

function solution(ineq, eq, n, m) {
    let answer = 0;
    
    answer = compare(ineq, eq, n, m);
    
    return answer;
}