function solution(numlist, n) {
    let answer = numlist;
    
    answer.sort((a, b) => {
        const aDiff = Math.abs(n - a);
        const bDiff = Math.abs(n - b);

        if (aDiff === bDiff) return b - a;
        else return aDiff - bDiff;
    });
    
    return answer;
}