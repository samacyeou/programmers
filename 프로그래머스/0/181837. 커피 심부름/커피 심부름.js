function calculatePrice(order) {
    const price = {
        anything: 4500,
        americano: 4500,
        cafelatte: 5000
    }
    let totalPrice = 0;
    
    for (let coffee of order) {
        for (let pay in price) {
            if (coffee.includes(pay)) {
                totalPrice += price[pay];
                break;
            }
        }
    }
    
    return totalPrice;
}

function solution(order) {
    let answer = 0;
    
    answer = calculatePrice(order);
    
    return answer;
}