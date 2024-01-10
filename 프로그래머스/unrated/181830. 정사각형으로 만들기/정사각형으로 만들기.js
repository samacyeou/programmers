function makeSquare(arr) {
    const diff = arr.length - arr[0].length;
    
    if (diff < 0) {
        for (let i = 0; i > diff; i--) {
            const temp = new Array(arr[0].length);
            temp.fill(0);
            arr.push(temp);
        }
    } else if (diff > 0) {
        for (let i = 0; i < arr.length; i++) {
            const temp = new Array(diff);
            temp.fill(0);
            arr[i] = arr[i].concat(temp);
        }
    }
    
    return arr;
}

function solution(arr) {
    let answer = [[]];
    
    answer = makeSquare(arr);
    
    return answer;
}