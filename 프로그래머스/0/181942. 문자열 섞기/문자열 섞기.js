function stringMix(str1, str2) {
    let result = '';
    
    for (let i = 0; i < str1.length; i++) {
        result += str1[i];
        result += str2[i];
    }
    
    return result;
}

function solution(str1, str2) {
    let answer = '';
    
    answer = stringMix(str1, str2);
    
    return answer;
}