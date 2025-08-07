function solution(n) {
    if(n === 1) return 1;
    if(n === 2) return 2;
    let acc1 = 1;
    let acc2 = 2;
    let acc3 = 0;
    for(let i=3; i<=n; i++) {
        acc3 = (acc1 + acc2) % 1_000_000_007;
        acc1 = acc2;
        acc2 = acc3;
    }
    return acc3;
}