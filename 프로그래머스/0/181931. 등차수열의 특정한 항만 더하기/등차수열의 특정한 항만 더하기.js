function sum(a, d, included) {
    let result = 0;
    included.forEach((element, index) => {
        if (element) result += a + d * index;
    })
    
    return result;
}

function solution(a, d, included) {
    let answer = 0;
    
    answer = sum(a, d, included);
    
    return answer;
}