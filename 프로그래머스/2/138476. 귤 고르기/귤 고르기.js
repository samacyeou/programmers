function solution(k, tangerine) {
    let result=0;
    const map = new Map();
    const set = new Set(tangerine);
      tangerine.forEach((size)=>{
        if(!map.has(size)){
            map.set(size,1);
        }else{
            const count = map.get(size);
            map.set(size, count+1);
        }
    })
    const sorted = Array(...set).sort((a,b)=>{
        const aCount = map.get(a);
        const bCount = map.get(b);
        return bCount - aCount;
    });

    if(k === 1) return 1
    console.log(sorted)
    let temp=0;
    for(let size of sorted){
        const count = map.get(size);
        temp += count;
        result +=1;
        if(temp>=k){
            break
        }
    }

    return result;
}