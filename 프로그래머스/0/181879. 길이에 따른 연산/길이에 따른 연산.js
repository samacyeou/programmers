const validate = (num_list) => {
    const limit1 = num_list.length >= 2 && num_list.length <= 20;
    const limit2 = !num_list.some(p => p < 1 && p > 9);
    // let m = 1;
    // num_list.forEach(el => m = m*el);
    // const limit3 = m <= 2147483647;
    return limit1&&limit2;
}
function solution(num_list) {
    var answer = 0;

    if (validate(num_list)) {
        const listLength = num_list.length;
        if (listLength >= 11) {
            num_list.forEach(el => answer+=el)
        } else {
            answer = 1;
            num_list.forEach(el => answer = answer*el);
        }
    }
    return answer;
}