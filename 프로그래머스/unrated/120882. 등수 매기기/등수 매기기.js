function calculateScore(score) {
    const rank = new Array(score.length);
    const average = {};
    
    for (let i = 0; i < score.length; i++) {
        const sum = score[i].reduce((acc, value) => {
            return acc + value;
        }, 0);
        
        average[i] = sum / 2;
    }
    
    rank.fill(1);
    
    for (let i in average) {
        const currentScore = average[i];
        for (let j in average) {
            if (i === j) continue;
            else if (average[j] > currentScore) rank[i]++;
        }
    }
    
    return rank;
}

function solution(score) {
    let answer = [];
    
    answer = calculateScore(score);
    
    return answer;
}