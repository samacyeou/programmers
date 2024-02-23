function makeArray(intStrs, k, s, l) {
    const result = [];

    intStrs.forEach(element => {
        const number = +element.slice(s, s + l);
        if (number > k) result.push(number);
    });
    
    return result;
}

function solution(intStrs, k, s, l) {
    let answer = [];
    
    answer = makeArray(intStrs, k, s, l);
    
    return answer;
}