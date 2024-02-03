function calculateSum(s) {
    const stack = [];
    const items = s.split(' ');
    let temp = '';
    
    for (let item of items) {
        if (item !== 'Z' && temp && temp !== 'Z') stack.push(+temp);
        temp = item;
    }
    
    if (temp && temp !== 'Z') stack.push(+temp);
    
    return stack.reduce((acc, element) => acc + element, 0);
}

function solution(s) {
    let answer = 0;
    
    answer = calculateSum(s);
    
    return answer;
}