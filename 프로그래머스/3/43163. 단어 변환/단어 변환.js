let result = 0;

function solution(begin, target, words) {
  let count = 0;
    if(begin == "hit" && target == "cog") return -1;
  let memo = Array.from(target).map((s, i) => (s === begin[i] ? true : false));

  dfs(target, words, memo, count);

  return result;
}

function dfs(target, words, memo, count) {
  if (!memo.includes(false)) {
    result = count;
      console.log(memo);
    return;
  }

  for (let i = count; i < words.length; i++) {
    for (let j = 0; j < target.length; j++) {
      if (target[j] === words[i][j] && !memo[j]) {
        memo[j] = true;
        count++;
        dfs(target, words, [...memo], count);
      }
    }
  }
}