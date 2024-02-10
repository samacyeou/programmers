function sortEmergency(emergency) {
    const emergencyRank = new Array(emergency.length).fill(0);
    const length = emergency.length;
    
    for (let i = 0; i < length; i++) {
        for (let j = 0; j < length; j++) {
            if (emergency[i] <= emergency[j]) emergencyRank[i]++;
        }
    }
    
    return emergencyRank;
}

function solution(emergency) {
    let answer = [];
    
    answer = sortEmergency(emergency);
    
    return answer;
}