function solution(str1,str2){
    let answer=[];
    let [str1Sl,str2Sl]=[[],[]];
    let strMap=new Map();
    [str1,str2]=[str1.toLowerCase(),str2.toLowerCase()];
    function arrPush(length,strArr,slArr){
        for(let i=0;i<length-1;i++){
            const str=strArr.slice(i,i+2);
            if(isAlphabet(str)){
                slArr.push(str);
                strMap.set(str,(strMap.get(str)||0)+1);
            }
        }
    }
    arrPush(str1.length,str1,str1Sl);
    arrPush(str2.length,str2,str2Sl);

    const cal=(arr)=>{
        const map=new Map();
        for(const str of arr){
            map.set(str,(map.get(str)||0)+1);
        }
        return map;
    }
    const map1=cal(str1Sl);
    const map2=cal(str2Sl);

    let intersection=0;
    let union=0;
    let unionMap=new Map();
    for(const [key,value] of map1){
        if(map2.has(key)){
            intersection+=Math.min(value,map2.get(key));
            unionMap.set(key, Math.max(value, map2.get(key)));
            // if(unionMap.get(key)){
            //     unionMap.delete(key);
            // }
        }else{
            unionMap.set(key,value);
        }
    }
    for(const [key,value] of map2){
        if(!map1.has(key)) unionMap.set(key,value);
    }
    for(const [key,value] of unionMap){
        union+=value;
    }
    answer=union===0?65536:Math.floor((intersection/union)*65536);
    return answer;
}
function isAlphabet(str){
    str=str.split('');
    if(/^[a-zA-Z]$/.test(str[0]) && /^[a-zA-Z]$/.test(str[1]))
        return true;
    return false;
}