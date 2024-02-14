function countString(myString, pat) {
    let count = 0;
    let check = true;
    
    for (let i = 0; i < myString.length; i++) {
        for (let j = 0; j < pat.length; j++) {
            if (myString[i+j] !== pat[j]) {
                check = false;
                break;
            }
        }
        if (check) count++;
        check = true;
    }
    
    return count;
}

function solution(myString, pat) {
    let answer = 0;
    
    answer = countString(myString, pat);
    
    return answer;
}