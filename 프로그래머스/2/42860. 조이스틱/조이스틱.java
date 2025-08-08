class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int minRound = len - 1;
        int pos = 0;
        char ch = ' ';

        for(int i = 0; i < len; i++) {
            ch = name.charAt(i);
            if(ch != 'A') {
                answer += Math.min(ch - 'A', 'Z' - ch + 1);
                minRound = pos < len - i ?
                    Math.min(minRound, pos * 2 + (len - i)) :
                    Math.min(minRound, (len - i) * 2 + pos);
                pos = i;
            }
        }

        answer += Math.min(minRound, pos);

        return answer;
    }
}