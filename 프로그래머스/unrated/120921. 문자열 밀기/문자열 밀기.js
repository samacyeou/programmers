function checkSamePossible(source, object) {
    const board = object.repeat(2);
    
    return board.indexOf(source) || 0;
}

function solution(A, B) {
    let answer = 0;
    
    answer = checkSamePossible(A, B);
    
    return answer;
}