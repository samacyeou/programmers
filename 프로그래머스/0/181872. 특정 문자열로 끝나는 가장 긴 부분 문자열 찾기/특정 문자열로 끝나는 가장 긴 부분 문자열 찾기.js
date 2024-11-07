const validate = (myString, pat) => {
    const limit1 = myString.length >= 5 && myString.length <= 20;
    // const limit2 = pat.length >= 1 && pat.length <= 5;
    // return limit1 && limit2;
    return limit1
}
function solution(myString, pat) {
    var answer = '';
    if (validate(myString, pat)) {
        const strSplit = myString.split(pat);
        strSplit.forEach((el,i) => {
            if (i !== strSplit.length-1) answer += el + pat
        })

    }
    return answer;
}