function solution(n) {
    var answer = 0;
    let na="";

    // while(n / 3 >= 1){
    //     temp = n % 3
    //     if(!(temp === 0 && !na)) na += n % 3
    //     n=Math.floor(n/3)
    // }
    
    while(n/3>=1){
        na += `${n%3}` //45/3 =15 나머지 0  15/3 = 5 / 3 
        n=Math.floor(n/3)
    }
    
    na += n;
    let idx = 0;
    while(true) {
        if(na[idx] !== "0") break;
        idx++;
    }
    
    for(let i = na.length - 1; i >= 0; i--) {
        answer += 3 ** (na.length - 1 - i) * na[i];
    }
    // answer= parseInt(Number(na),3)
    
    return answer;
}