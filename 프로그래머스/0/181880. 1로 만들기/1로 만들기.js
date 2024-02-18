function countCalculate(num_list) {
    let count = 0;
    
    for (let num of num_list) count += Math.floor(Math.log2(num));
    
    return count;
}

function solution(num_list) {
    let answer = 0;
    
    answer = countCalculate(num_list);
    
    return answer;
}