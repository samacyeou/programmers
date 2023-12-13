function checkParallel(dots) {
    let dot = dots[0];
    let check = 0;
    
    for (let i = 1; i < dots.length; i++) {
        let inclination1 = (dots[i][1] - dot[1]) / (dots[i][0] - dot[0]);
        let index1 = Math.ceil((6 - i) / 2 + 0.1);
        let index2 = Math.floor((6 - i) / 2 - 0.1);
        let inclination2 = (dots[index1][1] - dots[index2][1]) / (dots[index1][0] - dots[index2][0]);
        if (inclination1 === inclination2) {
            check = 1;
            break;
        }
    }
    
    return check;
}

function solution(dots) {
    let answer = 0;
    
    answer = checkParallel(dots);
    
    return answer;
}