function calculate(chicken) {
    let value = 0;
    let restCoupon = 0;
    
    while (chicken >= 10) {
        value += Math.floor(chicken / 10);
        restCoupon = chicken % 10;
        chicken = Math.floor(chicken / 10);
        chicken += restCoupon;
    }
    
    return value;
}

function solution(chicken) {
    const answer = calculate(chicken);
    
    return answer;
}