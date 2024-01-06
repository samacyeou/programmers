function findWord(spell, dic) {
    let findCheck = 2;
    const dictionary = dic.filter((element) => element.length >= spell.length);
    
    for (let word of dictionary) {
        for (let spelling of spell) {
            word = word.replace(spelling, "");
        }
        
        if (!word) {
            findCheck = 1;
            break;
        }
    }
    
    return findCheck;
}

function solution(spell, dic) {
    let answer = 0;
    
    answer = findWord(spell, dic);
    
    return answer;
}