import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int sum = Arrays.stream(picks).sum();
        int point = 0;
        int[] idx = new int[sum];
        HashMap<String, Integer> fatigue = new HashMap<>();
        HashMap<Integer, Integer> fP = new HashMap<>();
        
        fatigue.put("diamond", 31);
        fatigue.put("iron", 6);
        fatigue.put("stone", 1);
        
        for(int i = 0; i < sum; i++) idx[i] = i;
        
        for(int i = 0; i < minerals.length && i < sum * 5; i++) {
            point += fatigue.get(minerals[i]);
            if(i % 5 == 4 || i == minerals.length - 1) {
                fP.put(i / 5, point);
                point = 0;
            }
        }

        int temp = 0;
        for(int i = 0; i < fP.size(); i++) {
            for(int j = i + 1; j < fP.size(); j++) {
                if(fP.get(idx[i]) < fP.get(idx[j])) {
                    temp = idx[i];
                    idx[i] = idx[j];
                    idx[j] = temp;
                }
            }
        }
        
        // temp: 곡괭이 인덱스
        for(int i = 0; i < fP.size(); i++) {
            if(picks[0] > 0) temp = 0;
            else if(picks[1] > 0) temp = 1;
            else if(picks[2] > 0) temp = 2;
            for(int j = idx[i] * 5; j < idx[i] * 5 + 5 && j < minerals.length; j++) {
                if(temp == 0) answer++;
                else if(temp == 1) answer += (int)Math.ceil((float)fatigue.get(minerals[j]) / 6.2f);
                else if(temp == 2) answer += (int)Math.ceil((float)fatigue.get(minerals[j]) / 1.24f);
            }
            
            picks[temp]--;
        }

        return answer;
    }
}