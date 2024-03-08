function readString(str, m, c) {
    let result = '';
    
    for (let i = 0; i < str.length; i++) {
        if (i % m + 1 === c) result += str[i];
    }
    
    return result;
}

function solution(my_string, m, c) {
    let answer = '';
    
    answer = readString(my_string, m, c);
    
    return answer;
}