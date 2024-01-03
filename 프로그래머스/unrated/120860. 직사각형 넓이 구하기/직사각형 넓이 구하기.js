function calculateArea(dots) {
    const standard = dots[0];
    let area = 0;
    
    for (let i = 1; i < dots.length; i++) {
        if (standard[0] !== dots[i][0] && standard[1] !== dots[i][1]) {
            area = Math.abs(standard[0] - dots[i][0]) * Math.abs(standard[1] - dots[i][1]);
            break;
        }
    }
    
    return area;
}

function solution(dots) {
    let answer = 0;
    
    answer = calculateArea(dots);
    
    return answer;
}