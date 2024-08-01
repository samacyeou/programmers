function solution(bandage, health, attacks) {
    const 최대체력 = health;
    let 현재체력 = 최대체력;

    const 시전시간 = bandage[0];
    const 초당회복량 = bandage[1];
    const 추가회복량 = bandage[2];

    let 현재시간 = 1;
    let retire = false;
    attacks.map(공격 => {
        let 다음공격시간 = 공격[0];
        let 데미지 = 공격[1];

        // 체력 회복
        let 회복시간카운터 = 0;
        for (현재시간 ; 현재시간 < 다음공격시간 ; 현재시간++){
            현재체력 = 현재체력 + 초당회복량;

            회복시간카운터 = 회복시간카운터 + 1;
            if (회복시간카운터 === 시전시간){
                현재체력 = 현재체력 + 추가회복량;
                회복시간카운터 = 0;
            }

            if(현재체력 > 최대체력){
                현재체력 = 최대체력
            }
        }

        현재체력 = 현재체력 - 데미지
        if(현재체력 <= 0) retire = true;
        현재시간++
    })

    var answer = retire ? -1 : 현재체력
    console.log('최종체력 : ', answer)
    return answer
}