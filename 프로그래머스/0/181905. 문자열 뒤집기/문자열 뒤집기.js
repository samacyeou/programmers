function reverseOfStringPart(my_string, s, e) {
    let result = my_string.slice(0, s);
    
    for (let i = 0; i <= e - s; i++) result += my_string[e - i];
    result += my_string.slice(e + 1);
    
    return result;
}

function solution(my_string, s, e) {
    let answer = '';
    
    answer = reverseOfStringPart(my_string, s, e);
    
    return answer;
}