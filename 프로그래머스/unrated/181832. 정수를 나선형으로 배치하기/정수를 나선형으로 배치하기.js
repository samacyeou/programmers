function buildLabyrinth(n) {
    let value = 1;
    let temp = new Array(n);
    const destination = n * n;
    
    for (let i = 0; i < n; i++) {
        temp[i] = new Array(n);
    }
    
    let mode = 1;
    let row = 0;
    let column = 0;
    
    while (value <= destination) {
        if (!(row >= 0 && row < n && column >= 0 && column < n) || temp[row][column]) {
            switch(mode) {
                case 1 :
                    column--;
                    row++;
                    mode = 2;
                    break;
                case 2 :
                    row--;
                    column--;
                    mode = 3;
                    break;
                case 3 :
                    column++;
                    row--;
                    mode = 4;
                    break;
                case 4 :
                    row++;
                    column++;
                    mode = 1;
                    break;
            }
        } else {
            temp[row][column] = value++;
            switch(mode) {
                case 1 : column++; break;
                case 2 : row++; break;
                case 3 : column--; break;
                case 4 : row--; break;
            }
        }
    }
    
    return temp;
}

function solution(n) {
    let answer = [[]];
    
    answer = buildLabyrinth(n);
    
    return answer;
}