function addPart(arr, queries) {
    queries.forEach(element => {
        for (let i = element[0]; i <= element[1]; i++) arr[i]++;
    })
    
    return arr;
}

function solution(arr, queries) {
    let answer = [];
    
    answer = addPart(arr, queries);
    
    return answer;
}