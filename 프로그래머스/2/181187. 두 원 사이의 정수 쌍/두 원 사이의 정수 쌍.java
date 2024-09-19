class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long sr = r1;
        long br = r2;
        long y1 = 0;
        long y2 = 0;
        
        for(long l = -br; l <= br; l++) {
            if(l <= -sr || sr <= l) {
                answer += (long)Math.sqrt(br * br - l * l) * 2 + 1;
            } else {
                y1 = (long)Math.sqrt(sr * sr - l * l);
                y2 = (long)Math.sqrt(br * br - l * l);
                if(y1 * y1 + l * l == sr * sr) {
                    answer += (y2 - y1 + 1) * 2;
                } else {
                    answer += (y2 - y1) * 2;
                }
            }
        }
        
        return answer;
    }
}