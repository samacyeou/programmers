function calculateString(my_string) {
    const item = my_string.split(' ');
    let result = +item[0];
    
    for (let i = 1; i < item.length; i+=2) {
        if (item[i] === '+') {
            result += +item[i+1];
        } else if (item[i] === '-') {
            result -=  +item[i+1];
        }
    }
    
    return result;
}

function solution(my_string) {
    let answer = 0;
    
    answer = calculateString(my_string);
    
    return answer;
}