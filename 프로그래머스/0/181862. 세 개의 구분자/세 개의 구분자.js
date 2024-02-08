function splitString(myStr) {
    let result = [];
    let startIndex = 0;
    const reg = new RegExp('[abc]');

    for (let i = 0; i <= myStr.length; i++) {
        if (reg.test(myStr[i]) || i === myStr.length) {
            if (startIndex !== i) result.push(myStr.slice(startIndex, i));
            startIndex = i + 1;
        }
    }
    
    if (result.length === 0) result.push("EMPTY");
    
    return result;
}

function solution(myStr) {
    let answer = [];
    
    answer = splitString(myStr);
    
    return answer;
}