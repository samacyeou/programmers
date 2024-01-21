function makeArray(arr) {
    const stack = [];
    let min = 0;
    
    for (let num of arr) {
        if (!stack.length) stack.push(num);
        else if (stack[stack.length-1] < num) stack.push(num);
        else {
            while(stack[stack.length-1] >= num) stack.pop();
            stack.push(num);
        }
    }
    
    return stack;
}

function solution(arr) {
    let stk = [];
    
    stk = makeArray(arr);
    
    return stk;
}