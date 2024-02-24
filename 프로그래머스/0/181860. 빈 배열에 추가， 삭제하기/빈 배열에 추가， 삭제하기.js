function makeArray(arr, flagList) {
    let result = [];
    
    flagList.forEach((flag, index) => {
        if (flag) {
            const temp = new Array(arr[index] * 2).fill(arr[index]);
            result = result.concat(temp);
        } else result = result.slice(0, result.length - arr[index]);
    })
    
    return result;
}

function solution(arr, flag) {
    let answer = [];
    
    answer = makeArray(arr, flag);
    
    return answer;
}