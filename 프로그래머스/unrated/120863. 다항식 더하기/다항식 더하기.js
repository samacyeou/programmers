function calculator(polynomial) {
    const array = polynomial.split(" + ");
    const calculate = { "x": 0, "constant": 0,};
    
    for (let n of array) {
        if (n.includes("x")) {
            if (n.length === 1) calculate["x"]++;
            else {
                calculate["x"] += +n.slice(0, n.length - 1);
            }
        } else calculate["constant"] += +n;
    }
    
    let constraction = 0;
    let coefficient = calculate["x"];
    let constant = calculate["constant"];
    
    if (coefficient === 1) {
        if (constant) constraction = `x + ${constant}`;
        else constraction = "x";
    } else if (coefficient >= 2) {
        if (constant) constraction = `${coefficient}x + ${constant}`;
        else constraction = `${coefficient}x`;
    } else constraction = `${constant}`;
    
    return constraction;
}

function solution(polynomial) {
    let answer = '';
    
    answer = calculator(polynomial);
    
    return answer;
}