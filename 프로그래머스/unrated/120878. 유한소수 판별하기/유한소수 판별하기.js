function solution(a, b) {
    let answer = 512 * 625 * a % b === 0 ? 1 : 2;
    return answer;
}