function solution(park, routes) {

    let pathArr = [];

    const WIDTH = park[0].length;

    const HEIGHT = park.length;

    for(let rowIdx = 0; rowIdx < park.length; rowIdx++){

        const row = park[rowIdx].split("");

        if(row.includes("S")){

            const columnIdx = park[rowIdx].indexOf("S");

            pathArr.push([columnIdx, rowIdx]);

            break;

        }

    }

    for(let i = 0; i<routes.length; i++) {

        const DIRECTION = routes[i].split(' ')[0];

        const AMOUNT = Number(routes[i].split(' ')[1]);

        let blockPos = [-1, -1];

        let x = pathArr[pathArr.length-1][0];

        let y = pathArr[pathArr.length-1][1];
        
        if (DIRECTION === "E") {
            if(park[y].slice(x, x+1+AMOUNT).includes("X")) continue;
            x = x + AMOUNT;
        } else if (DIRECTION === "W"){
            if(park[y].slice(x - AMOUNT >= 0 ? x - AMOUNT : 0, x).includes("X")) continue;
            x = x - AMOUNT;
        } else if (DIRECTION === "S"){
            if(park.findIndex((row, idx) => idx <= y + AMOUNT && idx >= y && row[x] === "X") !== -1) continue;
            y = y + AMOUNT;
        } else if (DIRECTION === "N"){

            if(park.slice(0, y).findIndex((row, idx) => idx >= y - AMOUNT && row[x] === "X") !== -1) continue;
            y = y - AMOUNT;
        }

        if (x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT){
            continue;
        }

        pathArr.push([x, y]);
        // console.log([x,y]);
    }

    return pathArr[pathArr.length-1].reverse();

}