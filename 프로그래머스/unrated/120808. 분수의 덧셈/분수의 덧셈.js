function catBox(number1, number2) {
    if (number1 % number2 === 0) return number2;
    else {
        return catBox(number2, number1 % number2);
    }
}

function tongbun(numer1, denom1, numer2, denom2) {
    const numer = numer1 * denom2 + numer2 * denom1;
    const denom = denom1 * denom2;
    
    return [numer, denom]
}

function yacbun(numer, denom) {
    const divisor = catBox(numer,denom);
    
    numer /= divisor;
    denom /= divisor;
    
    return [numer, denom];
}



function solution(numer1, denom1, numer2, denom2) {
    let answer = [];
    
    let [numer, denom] = tongbun(numer1, denom1, numer2, denom2);

    [numer, denom] = yacbun(numer, denom);
    
    answer = [numer, denom];

    return answer;
}