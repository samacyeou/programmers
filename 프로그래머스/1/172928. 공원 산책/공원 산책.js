function solution(park, routes) {
    var answer = [];
    const parkMaxSizeX = park.length - 1;
    let parkMaxSizeY = park[0].length - 1;
    const parkMinSize = 0
    let startArr = [];
    const blockMap = new Map();

    for (let [x, lineStr] of park.entries()){
        const line = lineStr.split('');
        for (let [y, dot] of line.entries()){
            if(dot === "S"){
                startArr = [x, y];
            }else if (dot === "X"){
                blockMap.set(JSON.stringify([x,y]), dot);
            }
        }
    }

    for(route of routes){
        const [dir, deg] = route.split(' ');
        let copyStart = [startArr[0], startArr[1]];
        let nowloc = [];

        let isSuccess = true;
        if(dir === 'S'){
            for(let i = copyStart[0]; i <= parseInt(deg) + copyStart[0]; i++){

                if(parseInt(deg) + copyStart[0] > parkMaxSizeX){
                    isSuccess = false;
                    break;
                }else{
                    let temp = [i, copyStart[1]];
                    let blockTest = blockMap.has(JSON.stringify(temp));

                    if(blockTest){
                        isSuccess = false;
                        break;
                    }
                }
                nowloc = [i, copyStart[1]];
            }
        }
        if(dir === 'N'){
            for(let i = copyStart[0]; i >= copyStart[0] - parseInt(deg); i--){

                if( copyStart[0] - parseInt(deg) < parkMinSize){
                    isSuccess = false;
                    break;
                }else{
                    let temp = [i, copyStart[1]];
                    let blockTest = blockMap.has(JSON.stringify(temp));
                    if(blockTest){
                        isSuccess = false;
                        break;
                    }
                }

                nowloc = [i, copyStart[1]];
            }
        }
        if(dir === 'E'){
            for(let i = copyStart[1]; i <= parseInt(deg) + copyStart[1]; i++){

                if(parseInt(deg) + copyStart[1] > parkMaxSizeY){
                    isSuccess = false;
                    break;
                }else{
                    let temp = [copyStart[0], i];
                    let blockTest = blockMap.has(JSON.stringify(temp));
                    if(i > parkMaxSizeY || blockTest){
                        isSuccess = false;
                        break;
                    }
                }

                nowloc = [copyStart[0], i];
            }
        }
        if(dir === 'W'){
            for(let i = copyStart[1]; i >= copyStart[1] - parseInt(deg); i--){

                if(copyStart[1] - parseInt(deg) < parkMinSize){
                    isSuccess = false;
                    break;
                }else{
                    let temp = [copyStart[0], i];
                    let blockTest = blockMap.has(JSON.stringify(temp));

                    if(blockTest){
                        isSuccess = false;
                        break;
                    }
                }
                nowloc = [copyStart[0], i];
            }
        }

        if(isSuccess){
            startArr = [...nowloc];
        }
        answer = [...startArr];
    }

    return answer;
}


// node LV1/공원산책.js