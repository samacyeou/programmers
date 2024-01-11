function makeArray(arr, k) {
    const dic = {}
    let array = [];
    
    for (let i = 0; i < arr.length && array.length < k; i++) {
        if (dic[arr[i]]) continue;
        else {
            array.push(arr[i]);
            dic[arr[i]] = true;
        }
    }
    
    if (array.length < k) array = array.concat(Array(k-array.length).fill(-1));

    return array;
}

function solution(arr, k) {
    let answer = [];
    
    answer = makeArray(arr, k);
    
    return answer;
}