/*

0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열 dartResult

 총 3번의 기회
 Single(S)**1
 Double(D)**2
 Triple(T)**3

 스타상 * 해당 점수와 바로 전에 얻은 점수를 각 2배
    첫번째 기회 -> 첫 번째 스타상(*)의 점수만 2배
    중첩 -> 중첩된 스타상(*) 점수는 4배
 아차상 # 해당 점수는 마이너스
 스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
*/

function solution(dartResult) {
    const dict = {"S" : 1,"D" : 2,"T" : 3}
    const option = {"*" : 2, "#" : -1}

    const length = dartResult.length;

    let dartScore = [];

    while(dartResult[0]){
        const cur = parseInt(dartResult)
        const len = cur ? (cur+ "").length : 1;
        if(Number.isInteger(cur)) dartScore.push([cur]);
        else dartScore[dartScore.length - 1].push(dartResult[0]);

        dartResult = dartResult.slice(len)
    }

    let total = 0;
    let prev = 0;
    let scoreList = []
    for(let i = 0; i < dartScore.length; i++){
        const [scores, dis, ops] = dartScore[i];
        const score = +scores;
        const di = dict[dis];
        const op = option[ops];

        let currentScore = score ** di;
        if(op){
            currentScore *= op;
            if(op === 2 & i !== 0) scoreList[i - 1] *= 2
        }
        // total += currentScore;
        // prev = currentScore;
        scoreList[i] = currentScore;
    }
    
    total = scoreList.reduce((acc, item) => acc + item, 0);

    return total;
}