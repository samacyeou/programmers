function solution(array) {
array.sort((a,b) => b - a);
    console.log(array);
return array[Math.trunc(array.length / 2)]
}