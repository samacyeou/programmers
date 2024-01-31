function binaryCalculate(bin1, bin2) {
    const int1 = parseInt(bin1, 2);
    const int2 = parseInt(bin2, 2);
    const result = int1 + int2;
    
    return result.toString(2);
}

function solution(bin1, bin2) {
    let answer = '';

    answer = binaryCalculate(bin1, bin2);
    
    return answer;
}