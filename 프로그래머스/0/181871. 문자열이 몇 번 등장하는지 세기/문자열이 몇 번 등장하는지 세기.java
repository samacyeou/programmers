class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int idx = -1;
        int prev = 0;

        while (myString.indexOf(pat, idx + 1) != -1) {
            if (idx == prev) {
                idx = myString.indexOf(pat, idx + 1);
                continue;
            }
            answer++;
            prev = idx;
        }

        return answer;
    }
}