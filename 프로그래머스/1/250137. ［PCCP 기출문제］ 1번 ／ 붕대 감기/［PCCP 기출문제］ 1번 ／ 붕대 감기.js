function solution(bandage, health, attacks) {
    const maxHealth = health;
    let extraHealth = health;
    let turn = 0;
    let count = -1;
    while(true){
        if(attacks.length < 1 ){
            break;
        }
        let isAttacked = false;
        let attackedData = null;
        if(attacks[0][0] === turn){
            isAttacked = true;
            count = 0;
            attackedData = attacks.shift();
        }
        if(isAttacked){
            extraHealth = extraHealth - attackedData[1];
            if(extraHealth < 1 ){
                break;
            }
        }else{
            count = count + 1;
            if(maxHealth > extraHealth){
                if(count === bandage[0]){
                    extraHealth = extraHealth + bandage[1] + bandage[2]
                    count = 0;
                }else {
                    extraHealth = extraHealth + bandage[1]     
                }
            }
            if(maxHealth <= extraHealth) extraHealth = health
        }

        console.log(turn, extraHealth, count, isAttacked)
        turn = turn + 1;
    }


    return extraHealth > 0 ? extraHealth : -1;
}