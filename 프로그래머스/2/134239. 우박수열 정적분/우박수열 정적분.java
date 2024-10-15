import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        double dk = (double)k;
        List<Double> area = new ArrayList<>();
        
        while(dk > 1) {
            if(dk % 2 == 0) {
                area.add(dk * 3 / 4);
                dk /= 2;
            } else {
                area.add(dk * 2 + 0.5);
                dk = dk * 3 + 1;
            }
        }
        
        int lenA = area.size();
        for(int i = 0; i < ranges.length; i++) {
            for(int j = ranges[i][0]; j < lenA + ranges[i][1]; j++) {
                answer[i] += area.get(j);
            }

            if(ranges[i][0] > lenA + ranges[i][1]) answer[i] = -1;
        }
        
        return answer;
    }
}