function changeElement(arr, queries) {
    let temp = 0;
    
    for (let query of queries) {
        temp = arr[query[0]];
        arr[query[0]] = arr[query[1]];
        arr[query[1]] = temp;
    }
    
    return arr;
}

function solution(arr, queries) {
    let answer = [];
    
    answer = changeElement(arr, queries);
    
    return answer;
}