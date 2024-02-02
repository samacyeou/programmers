function countSeven(array) {
    const string = array.join('');
    const str = string.replaceAll('7', '');
    const count = string.length - str.length;
    
    return count
}

function solution(array) {
    let answer = 0;
    
    answer = countSeven(array);
    
    return answer;
}