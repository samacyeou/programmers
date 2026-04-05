class Solution {
    public int solution(int num) {
        int answer = 0;

        if (num == 1) return 0;

        while (num != 1) {
            if (answer > 400) return -1;
            if (num % 2 == 0) {
                num /= 2;
                answer++;
            } else {
                num *= 3;
                num++;
                answer++;
            }
        }
        return answer;
    }
}