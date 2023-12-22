function codeProcess(code) {
    let mode = false;
    let string = [];
    
    for (let i = 0; i < code.length; i++) {
        if (code[i] === "1") mode = !mode;
        else {
            if (mode && i % 2) {
                string.push(code[i]);
            } else if (!mode && !(i % 2)) {
                string.push(code[i]);
            }
        }
    }
    
    if (!string.length) string.push("EMPTY");
    
    return string.join('');
}

function solution(code) {
    let answer = '';
    
    answer = codeProcess(code);
    
    return answer;
}