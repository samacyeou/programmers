function makeArray(arr, queries) {
    let array;
    
    array = queries.map((element) => {
        const [start, end, limit] = element;
        let maxNumber = 0;
        for (let i = start; i <= end; i++) {
            if (arr[i] > limit && (!maxNumber || maxNumber > arr[i])) {
                maxNumber = arr[i];
            }
        }
        
        if (!maxNumber) {
            maxNumber = -1;
        }
        
        return maxNumber;
    });
    
    return array;
}

function solution(arr, queries) {
    let answer = [];
    
    answer = makeArray(arr, queries);
    
    return answer;
}