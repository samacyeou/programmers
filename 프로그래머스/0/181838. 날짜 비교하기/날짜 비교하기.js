function compareDate(date1, date2) {
    let result = 0;
    
    for (let i = 0; i < date1.length; i++) {
        if (date1[i] > date2[i]) break;
        else if (date1[i] < date2[i]) {
            result = 1;
            break;
        }
    }
    
    return result;
}

function solution(date1, date2) {
    let answer = 0;
    
    answer = compareDate(date1, date2);
    
    return answer;
}