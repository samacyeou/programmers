function makeCode(q, r, code) {
    const REG_EXP = new RegExp(`.{1,${q}}`, "g");
    const matchString = code.match(REG_EXP);
    let decode = [];
    
    for (let str of matchString) {
        decode.push(str[r])
    }
    
    return decode.join('');
}

function solution(q, r, code) {
    let answer = '';
    
    answer = makeCode(q, r, code);
    
    return answer;
}