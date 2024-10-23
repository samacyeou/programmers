function solution(friends, gifts) {

    let answer = {}
    let realAnswer = {};

    for (let friend of friends) {
        answer[friend] = { give: {}, take: 0, total: 0 };
        realAnswer[friend] = 0

        for (let otherFriend of friends) {
            answer[friend].give[otherFriend] = 0;
        }
    }

    gifts.forEach((gift, idx) => {
        const [giver, taker] = gift.split(' ');

        answer[giver].give[taker]++;
        answer[taker].take++;
    })

    for (let key in answer) {
        const { give, take } = answer[key];
        answer[key].total = reducer(give) - take
    }

    for (let key in answer) {
        for (let taker in answer[key].give) {
            let p1 = answer[key].give[taker] || 0;
            let p2 = answer[taker].give[key] || 0;

            if (key !== taker && (p1 === p2)) {
                let gave = answer[key].total;
                let took = answer[taker].total;

                let whoWillTake = Math.max(gave, took);

                if (gave === took) continue;
                if (whoWillTake === gave) {
                    realAnswer[key] += 1;
                }
            }
            else if (p1 > p2) {
                realAnswer[key] += 1;
            }
        }
    }

     return Math.max(0, ...Object.values(realAnswer).map(i => i))
}

function reducer(data) {
    return Object.values(data).reduce((acc, current) => acc + current, 0) 
}