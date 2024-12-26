import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer;
        HashMap<Integer, ArrayList<Integer>> pointOut = new HashMap<>();
        HashMap<Integer, int[]> count = new HashMap<>();
        
        for(int i = 0; i < edges.length; i++) {
            pointOut.putIfAbsent(edges[i][0], new ArrayList<Integer>());
            pointOut.get(edges[i][0]).add(edges[i][1]);
            
            count.putIfAbsent(edges[i][0], new int[]{0, 0});
            count.putIfAbsent(edges[i][1], new int[]{0, 0});
            count.get(edges[i][0])[1]++;
            count.get(edges[i][1])[0]++;
        }
        
        int point = 0;
        int donut = 0;
        int stick = 0;
        int eight = 0;
        int totalCount = 0;
        
        for(Integer i : count.keySet()) {
            int[] temp = count.get(i);
            if(temp[0] == 0 && temp[1] > 1) {
                point = i;
                totalCount = pointOut.get(i).size();
            } else {
                if(temp[0] >= 2 && temp[1] >= 2) eight++;
                if(temp[1] == 0) stick++;
            }
        }
        
        donut = totalCount - stick - eight;
        
        answer = new int[]{point, donut, stick, eight};
        
        return answer;
    }
}