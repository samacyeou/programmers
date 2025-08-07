function solution(n) {
let a = 1;
let b = 2;
for (let i = 3; i <= n; i++) {
    var next = (a + b + 1000000007) % 1000000007
    a = b;
    b = next;
}
return b;
}