function overwrite(my_string, overwrite_string, s) {
    const str = my_string.slice(0, s) + overwrite_string + my_string.slice(overwrite_string.length + s);
    
    return str;
}

function solution(my_string, overwrite_string, s) {
    let answer = '';
    
    answer = overwrite(my_string, overwrite_string, s);
    
    return answer;
}