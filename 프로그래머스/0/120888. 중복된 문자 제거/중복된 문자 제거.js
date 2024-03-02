function removeDuplicate(str) {
    const exist = {};
    let result = '';
    
    for (let char of str) {
        if (!exist[char]) {
            exist[char] = true;
            result += char;
        }
    }
    
    return result;
}

function solution(my_string) {
    let answer = '';
    
    answer = removeDuplicate(my_string);
    
    return answer;
}