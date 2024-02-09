function oneChar(s) {
    const char = {};
    
    for (let ch of s) {
        if (char[ch]) char[ch]++;
        else char[ch] = 1;
    }
    
    return Object.keys(char).filter(element => char[element] === 1).sort().join('');
}

function solution(s) {
    let answer = '';
    
    answer = oneChar(s);
    
    return answer;
}