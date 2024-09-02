import java.util.Collections;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public void dfs(HashMap<Integer, HashMap<Integer, Integer>> line, int pos, int time, int[] times) {
        if(!line.containsKey(pos)) return;
        List<Integer> keys = new ArrayList<>(line.get(pos).keySet());
        Collections.sort(keys);
        
        for(int i = 0; i < keys.size(); i++) {
            int temp = line.get(pos).get(keys.get(i));
            if(temp + time <= times[keys.get(i)]) {
                times[keys.get(i)] = temp + time;
            }
            
            if(temp + time > times[keys.get(i)]) continue;
            dfs(line, keys.get(i), time + temp, times);
        }
        
        return;
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] roadLine = {};
        int[] times = new int[N + 1];
        HashMap<Integer, HashMap<Integer, Integer>> line = new HashMap<>();
        
        Arrays.fill(times, 500000);
        
        for(int i = 0; i < road.length; i++) {
            roadLine = road[i];
            int small = roadLine[0] > roadLine[1] ? roadLine[1] : roadLine[0];
            int big = roadLine[0] > roadLine[1] ? roadLine[0] : roadLine[1];
            
            line.putIfAbsent(small, new HashMap<>());
            line.putIfAbsent(big, new HashMap<>());
            if(line.get(small).containsKey(big)) {
                int temp = line.get(small).get(big);
                temp = temp > roadLine[2] ? roadLine[2] : temp;
                line.get(small).put(big, temp);
                line.get(big).put(small, temp);
            } else {
                line.get(small).put(big, roadLine[2]);
                line.get(big).put(small, roadLine[2]);
            }
        }
        
        times[1] = 0;
        
        dfs(line, 1, 0, times);
        
        for(int i = 1; i <= N; i++) {
            if(times[i] <= K) answer++;
        }
        
        return answer;
    }
}