
function solution(a, b, n) {
    let sum = 0;

    let havingCoke = n;
    while (havingCoke >= a){
        let minus = Math.floor(havingCoke/a) * a;
        let plus = (minus/a) * b;
        sum += plus;
        havingCoke += -minus + plus;
    }
    return sum;
}

