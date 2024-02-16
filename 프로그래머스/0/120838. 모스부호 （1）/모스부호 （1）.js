const MORSE = { 
    '.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e','..-.':'f',
    '--.':'g','....':'h','..':'i','.---':'j','-.-':'k','.-..':'l',
    '--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r',
    '...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x',
    '-.--':'y','--..':'z'
}

function morseDecode(letter) {
    const codes = letter.split(' ');
    let result = '';
    
    for (let code of codes) result += MORSE[code];
    
    return result;
}

function solution(letter) {
    let answer = '';
    
    answer = morseDecode(letter);
    
    return answer;
}