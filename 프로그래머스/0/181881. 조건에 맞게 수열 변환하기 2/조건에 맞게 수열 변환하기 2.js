function countEquals(arr) {
    let count = 0;
    let nextArr = [];
    let correct = true;
    
    while(true) {
        nextArr = arr.map(element => {
            let value = element;
            if (element >= 50 && element % 2 === 0) {
                value /= 2;
            } else if (element < 50 && element % 2 === 1) {
                value = value * 2 + 1;
            }
            return value
        })
        
        for (let i = 0; i < arr.length; i++) {
            if (arr[i] !== nextArr[i]) {
                correct = false;
                break;
            }
        }
        
        if (correct) break;
        
        count++;
        arr = nextArr;
        correct = true;
    }
    
    return count;
}

function solution(arr) {
    let answer = 0;
    
    answer = countEquals(arr);
    
    return answer;
}