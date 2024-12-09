function solution(friends, gifts) {
    var answer = 0;
    //
    const record = {}; 
    const giftCount = {}  // 주고받은 횟수
    const giftPoint = {}; // 선물지수

    // Init
    friends.forEach(friend => {
        record[friend] = 0;
        giftPoint[friend] = 0; 
        friends.forEach(friend2 => {
            if(friend !== friend2){
                giftCount[friend+","+friend2] = 0
            }
        })
    });

    // Count gift point
    gifts.forEach(gift => {
        const [giver, receiver] = gift.split(' ');

        giftPoint[giver]++;
        giftPoint[receiver]--;
        giftCount[giver+","+receiver]++
    });

    const countGift = (friend1, friend2) => {
        //
        const f1Gave = giftCount[friend1+","+friend2]
        const f2Gave = giftCount[friend2+","+friend1]

        if(f1Gave > f2Gave){
            record[friend1]++
        } else if(f1Gave < f2Gave){
            record[friend2]++
        } else {
            const f1Point = giftPoint[friend1]
            const f2Point = giftPoint[friend2]

            if(f1Point > f2Point){
                record[friend1]++
            } else if(f1Point < f2Point){
                record[friend2]++
            }
        }
    }

    friends.forEach((friend1, i) => {
        for(let j = ++i; j < friends.length; j++){
            countGift(friend1, friends[j])
        }
    });

    console.log(record)
    answer = Math.max(...Object.values(record));
    return answer;
}