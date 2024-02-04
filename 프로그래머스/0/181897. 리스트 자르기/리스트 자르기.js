function sliceList(n, slicer, num_list) {
    let result = [];
    const [a, b, c] = slicer
    
    switch(n) {
        case 1 :
            result = num_list.slice(0, b + 1);
            break;
        case 2 :
            result = num_list.slice(a);
            break;
        case 3 :
            result = num_list.slice(a, b + 1);
            break;
        case 4 :
            for (let i = a; i < b + 1; i += c) result.push(num_list[i]);
            break;
    }
    
    return result;
}

function solution(n, slicer, num_list) {
    let answer = [];
    
    answer = sliceList(n, slicer, num_list);
    
    return answer;
}