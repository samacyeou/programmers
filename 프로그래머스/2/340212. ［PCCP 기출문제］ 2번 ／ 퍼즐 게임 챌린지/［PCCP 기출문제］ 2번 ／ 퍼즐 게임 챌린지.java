import java.util.Arrays;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int frontLevel = 0;
        int backLevel = Arrays.stream(diffs).max().getAsInt();
        int level = backLevel / 2;
        int timePrev = 0;
        long timeTemp = 0;
        
        int answer = backLevel;
        
        while(true) {
            if(frontLevel == level) break;
            
            for(int i = 0; i < times.length; i++) {
                if(diffs[i] <= level) timeTemp += times[i];
                else timeTemp += (timePrev + times[i]) * (diffs[i] - level) + times[i];
                
                timePrev = times[i];
            }
            
            if(limit >= timeTemp && answer > level) {
                answer = level;
                backLevel = level;
                level = (frontLevel + level) / 2;
            } else {
                frontLevel = level;
                level = (level + backLevel) / 2;
            }
            
            timeTemp = 0;
            timePrev = 0;
        }
        
        return answer;
    }
}