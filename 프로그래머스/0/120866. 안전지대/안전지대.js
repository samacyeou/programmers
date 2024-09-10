const solution = (board) => {

    // 지뢰 지역 변수
    let mineField = [];

    // 지뢰 지역 색출
    board.forEach((fieldX, locationX) => {
        fieldX.forEach((mine,locationY)=> {
            if(mine>0)mineField.push([locationX,locationY]);
        })
    });

    // 지뢰 비안전 지역
    let unsafetyField = [];
    mineField.forEach(location=>{
        unsafetyField.push(...unsafety(location));
    });

    // 비안전 지역 색출
    function unsafety([x,y]){
        return [[x,y],[x,y+1],[x+1,y+1],[x+1,y],[x+1,y-1],[x,y-1],[x-1,y-1],[x-1,y],[x-1,y+1]]
    };
    
    let count = 0;
    let temp = [];
    for(let i = 0; i < unsafetyField.length; i++) {
        let test = unsafetyField[i]
        if(test[0] >= 0 && test[0] < board.length && test[1] >= 0 && test[1] < board.length) {
            if(!temp.includes(JSON.stringify(unsafetyField[i]))) {
                count++;
                temp.push(JSON.stringify(unsafetyField[i]));
            }
        }
    }

    // 중복 및 board 영역 밖 좌표 제거
    unsafetyField = [...new Set(JSON.stringify(unsafetyField).match(/-*\d+,-*\d+/g))].map(data=>data.split(",").map(word=>parseInt(word))).filter(([x,y])=>x>=0&&y>=0&&x<board.length&&y<board.length);
    
    if(count != unsafetyField.length) return board[1000][0];

    // 안전 지역 검출 및 결과 전달
    let safetyField = Array(board.length).fill(Array(board.length).fill([])).map((arr,x)=>arr.map((_,y)=>[x,y]));
    return safetyField.flat().filter(data=> !unsafetyField.reduce((result,location)=>location[0]==data[0]&&location[1]==data[1]?true:result,false)).length;
}