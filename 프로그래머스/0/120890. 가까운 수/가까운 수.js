function findCloser(array, n) {
    let find = { number: array[0], diff: Math.abs(n - array[0]) };
    let diff = 0;
    
    for (let i = 1; i < array.length; i++) {
        diff = Math.abs(n - array[i]);
        if (diff < find.diff) {
            find.number = array[i];
            find.diff = diff;
        } else if (diff === find.diff && array[i] < find.number) find.number = array[i];    
    }
    
    return find.number;
}

function solution(array, n) {
    let answer = 0;
    
    answer = findCloser(array, n);
    
    return answer;
}