import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (a, b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });
        
        int end = -1;
        for(int[] target : targets) {
            if(target[0] >= end) {
                answer++;
                end = target[1];
            } else {
                end = Math.min(end, target[1]);
            }
        }

        return answer;
    }
}