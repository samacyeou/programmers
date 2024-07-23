class Solution {


fun solution(x: Int, n: Int): LongArray {
   var answer = longArrayOf()

for (i in 1..n) {
    answer += longArrayOf(x.toLong() * i)
}

return answer
}

}