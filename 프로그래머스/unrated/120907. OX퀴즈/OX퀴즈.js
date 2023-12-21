function quizAnswer(quiz) {
    let answers = [];
    
    for (let str of quiz) {
        const arr = str.split(' ');

        if (arr[1] === "+") {
            if (+arr[0] + +arr[2] === +arr[4]) answers.push("O");
            else answers.push("X");
        } else if (arr[1] === "-") {
            if (+arr[0] - +arr[2] === +arr[4]) answers.push("O");
            else answers.push("X");
        }
    }
    
    return answers;
}

function solution(quiz) {
    let answer = [];
    
    answer = quizAnswer(quiz);

    return answer;
}