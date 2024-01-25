function countChar(my_string) {
    const count = new Array(52).fill(0);
    
    for (let i = 0; i < my_string.length; i++) {
        const charCode = my_string.charCodeAt(i);
        if (charCode <= 90) count[charCode - 65]++;
        else count[charCode - 71]++;
    }
        
    return count;
}

function solution(my_string) {
    let answer = [];
    
    answer = countChar(my_string);
    
    return answer;
}