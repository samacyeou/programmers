import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public void progress(HashMap<Integer, int[]> point, int[][] routes, HashMap<Integer, int[]> position, HashMap<Integer, int[]> toward, HashMap<String, Integer> count, boolean[] completed, int index) {
        if(index == routes.length) return;
        
        if(!completed[index]) {
            int[] pos = position.get(index);
            int[] dest = toward.get(index);
            int[] nextPoint = point.get(dest[0]);
            String countKey = pos[0] + "," + pos[1];
            
            count.put(countKey, count.get(countKey) - 1);
            
            if(Arrays.equals(point.get(dest[0]), pos)) {
                if(dest[1] + 1 == routes[index].length) completed[index] = true;
                else {
                    dest[1]++;
                    dest[0] = routes[index][dest[1]];
                    nextPoint = point.get(dest[0]);
                }
            }
            
            if(pos[0] != nextPoint[0]) pos[0] += pos[0] > nextPoint[0] ? -1 : 1;
            else if(pos[1] != nextPoint[1]) pos[1] += pos[1] > nextPoint[1] ? -1 : 1;
            
            if(!completed[index]) {
                countKey = pos[0] + "," + pos[1];
                count.put(countKey, count.getOrDefault(countKey, 0) + 1);
            }
        }
        
        progress(point, routes, position, toward, count, completed, index+1);
        
        return;
    }
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int time = 0;
        int endTime = 0;
        HashMap<Integer, int[]> point = new HashMap<>();
        HashMap<Integer, int[]> position = new HashMap<>();
        HashMap<Integer, int[]> toward = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();
        boolean[] completed = new boolean[routes.length];
        
        for(int i = 0; i < points.length; i++) point.put(i+1, points[i]);
        
        for(int i = 0; i < routes.length; i++) {
            int[] point1 = point.get(routes[i][0]);
            position.put(i, new int[]{point1[0], point1[1]});
            toward.put(i, new int[]{routes[i][1], 1});
            
            String countKey = point1[0] + "," + point1[1];
            count.put(countKey, count.getOrDefault(countKey, 0) + 1);
            if(count.get(countKey) == 2) answer++;
            
            for(int j = 0; j < routes[i].length - 1; j++) {
                point1 = point.get(routes[i][j]);
                int[] point2 = point.get(routes[i][j+1]);
                
                time += Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
            }
            
            if(endTime < time) endTime = time;
            time = 0;
        }
        
        while(time <= endTime) {
            progress(point, routes, position, toward, count, completed, 0);
            
            for(Integer i : count.values()) {
                if(i >= 2) answer++;
            }
            
            time++;
        }
        
        return answer;
    }
}