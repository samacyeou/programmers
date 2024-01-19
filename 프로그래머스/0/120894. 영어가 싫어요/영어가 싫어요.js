function stringToNumber(numbers) {
    const numberList = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine'];
    
    for (let i = 0; i < numberList.length; i++) {
        numbers = numbers.replaceAll(numberList[i], i);
    }

    return +numbers;
}

function solution(numbers) {
    let answer = 0;
    
    answer = stringToNumber(numbers);
    
    return answer;
}