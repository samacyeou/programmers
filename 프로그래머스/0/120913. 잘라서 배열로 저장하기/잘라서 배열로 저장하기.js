function sliceToMakeArray(my_str, n) {
    const array = [];
    let startIndex = 0;
    
    while(startIndex < my_str.length) {
        array.push(my_str.slice(startIndex, startIndex + n))
        startIndex += n;
    }
    
    return array;
}

function solution(my_str, n) {
    let answer = [];
    
    answer = sliceToMakeArray(my_str, n);
    
    return answer;
}