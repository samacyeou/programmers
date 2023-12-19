function checkBoundary(index, boardLength) {
    let check = false;
    if (0 <= index && index < boardLength) check = true;
    
    return check;
}

function checkMine(board, row, column, boardLength) {
    let check = false;
    let next = false;
    
    for (let i = -1; i <= 1; i++) {
        if (checkBoundary(row + i, boardLength)) {
            for (let j = -1; j <= 1; j++) {
                if (checkBoundary(column + j, boardLength)) {
                    if (board[row+i][column+j]) {
                        check = true;
                        next = true;
                        break;
                    }
                }
            }
            
            if (next) break;
        }
    }
    
    return check
}

function countSafeZone(board) {
    const boardLength = board.length;
    let check = false;
    let count = 0;
    
    for (let i = 0; i < boardLength; i++) {
        for (let j = 0; j < boardLength; j++) {
            check = checkMine(board, i, j, boardLength);
            if (!check) count++;
            check = false;
        }
    }
    
    return count;
}

function solution(board) {
    let answer = 0;
    
    answer = countSafeZone(board);
    
    return answer;
}