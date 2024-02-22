function findLongPart(myString, pat) {
    const lastIndex = myString.lastIndexOf(pat);
    const result = myString.slice(0, lastIndex + pat.length);
    
    return result;
}

function solution(myString, pat) {
    let answer = '';
    
    answer = findLongPart(myString, pat);
    
    return answer;
}