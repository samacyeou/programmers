function eraseChar(my_string,indices) {
    const erase = {};
    let result = '';
    
    indices.forEach(element => erase[element] = true);
    for (let i = 0; i < my_string.length; i++) if (!erase[i]) result += my_string[i];
    
    return result;
}

function solution(my_string, indices) {
    let answer = '';
    
    answer = eraseChar(my_string, indices);
    
    return answer;
}