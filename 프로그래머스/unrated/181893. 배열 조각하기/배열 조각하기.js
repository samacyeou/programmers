function sliceArray(arr, query) {
    for (let i = 0; i < query.length; i++) {
        if (i % 2) arr = arr.slice(query[i]);
        else arr = arr.slice(0, query[i] + 1);
    }
    
    return arr;
}

function solution(arr, query) {
    let answer = [];
    
    answer = sliceArray(arr, query);
    
    return answer;
}