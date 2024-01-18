function makeArray(arr) {
    const stk = [];
    
    arr.forEach((element) => {
        if (!stk.length) stk.push(element);
        else if (stk[stk.length - 1] === element) stk.pop();
        else stk.push(element);
    })
    
    if (!stk.length) stk.push(-1);
    
    return stk;
}

function solution(arr) {
    let answer = [];
    
    answer = makeArray(arr);
    
    return answer;
}