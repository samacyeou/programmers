function sumNumber(my_string) {
    const REG = new RegExp("[a-zA-Z]");
    let start = 0;
    let hasNumber = false;
    let result = 0;
    
    for (let i = 0; i < my_string.length; i++) {
        if (REG.test(my_string[i]) && hasNumber) {
            result += +my_string.slice(start, i);
            hasNumber = false;
        } else if (!REG.test(my_string[i]) && !hasNumber) {
            start = i;
            hasNumber = true;
        }
    }
    
    if (hasNumber) result += +my_string.slice(start);
    
    return result;
}

function solution(my_string) {
    let answer = 0;
    
    answer = sumNumber(my_string);
    
    return answer;
}