function sizeUpPicture(picture, k) {
    const upSizePicture = [];
    for (let row of picture) {
        let temp = '';
        for (let c of row) temp += c.repeat(k);
        for (let i = 0; i < k; i++) upSizePicture.push(temp);
    }
    
    return upSizePicture;
}

function solution(picture, k) {
    let answer = [];
    
    answer = sizeUpPicture(picture, k);
    
    return answer;
}