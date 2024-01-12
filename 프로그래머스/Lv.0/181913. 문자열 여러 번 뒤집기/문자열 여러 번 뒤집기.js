function makeString(my_string, queries) {
    let string = my_string.split('');
    
    queries.forEach((element) => {
        const [start, end] = element;
        let reverseString = string.slice(start, end + 1).reverse();
        string = string.slice(0, start).concat(reverseString, string.slice(end + 1));
    })
    
    return string.join('');
}

function solution(my_string, queries) {
    let answer = '';
    
    answer = makeString(my_string, queries);
    
    return answer;
}