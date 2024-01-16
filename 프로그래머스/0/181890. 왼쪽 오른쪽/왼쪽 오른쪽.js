function makeArray(str_list) {
    let array = [];
    
    for (let i = 0; i < str_list.length; i++) {
        if (str_list[i] === "l") {
            array = str_list.slice(0, i);
            break;
        } else if (str_list[i] === "r") {
            array = str_list.slice(i + 1);
            break;
        }
    }
    
    return array;
}

function solution(str_list) {
    let answer = [];
    
    answer = makeArray(str_list);
    
    return answer;
}