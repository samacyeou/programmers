const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = [line];
}).on('close',function(){
    str = input[0];
    const small = new RegExp("[a-z]");
    let answer = "";
    
    for (let c of str) {
        if (small.test(c)) answer += c.toUpperCase();
        else answer += c.toLowerCase();
    }
    
    console.log(answer);
});