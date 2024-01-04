function nowPosition(keyinput, board) {
    const boderRow = (board[0] - 1) / 2;
    const boderColumn = (board[1] - 1) / 2;
    let pos = [0, 0]
    
    for (let move of keyinput) {
        if (move === "left") {
            if (Math.abs(pos[0] - 1) <= boderRow) pos[0]--;
        } else if (move === "right") {
            if (Math.abs(pos[0] + 1) <= boderRow) pos[0]++;
        } else if (move === "up") {
            if (Math.abs(pos[1] + 1) <= boderColumn) pos[1]++;
        } else if (move === "down") {
            if (Math.abs(pos[1] - 1) <= boderColumn) pos[1]--;
        }
    }
    
    return pos;
}

function solution(keyinput, board) {
    let answer = [];
    
    answer = nowPosition(keyinput, board);
    
    return answer;
}