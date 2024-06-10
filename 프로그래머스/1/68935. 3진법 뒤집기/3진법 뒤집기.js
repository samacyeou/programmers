function solution(n) {
    var answer = 0;
    let na="";

    while(n / 3 >= 1){
        temp = n % 3
        if(!(temp === 0 && !na)) na += n % 3
        n=Math.floor(n/3)
    }
    
    na += n;
    
    for(let i = na.length - 1; i >= 0; i--) {
        answer += 3 ** (na.length - 1 - i) * na[i];
    }
    // answer= parseInt(Number(na),3)
    
    return answer;
}