function countAnounceWord(babbling) {
    const WORDS = ["aya", "ye", "woo", "ma"];
    const WORDS_LENGTH = 4;
    let count = 0;
    
    for (let i = 0; i < babbling.length; i++) {
        let babblingWord = babbling[i];
        for (let j = 0; j < WORDS_LENGTH; j++) {
            if (babblingWord.indexOf(WORDS[j]) !== -1) {
                babblingWord = babblingWord.replaceAll(WORDS[j], "1");
            }
        }

        babblingWord = babblingWord.replaceAll("1", "");
        if (babblingWord === "") {
            count++;
        }
    }
    
    return count;
}

function solution(babbling) {
    let answer = 0;
    
    answer = countAnounceWord(babbling);
    
    return answer;
}