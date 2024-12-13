import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public void dfs(int[] info, int n, int index, int[] cur, List<int[]> curList) {
        if(n == 0 || index == 10) {
            cur[10] = n;
            
            int apeachP = 0;
            int lionP = 0;
            int arrowP = 0;
            int[] temp = new int[13];
            
            for(int i = 0; i < 11; i++) {
                if(info[i] != 0 && info[i] >= cur[i]) apeachP += 10 - i;
                else if(cur[i] > info[i]) lionP += 10 -i;
                
                temp[i] = cur[i];
                arrowP += cur[i] * (10 - i);
            }
            
            if(lionP > apeachP) {
                temp[11] = lionP - apeachP;
                temp[12] = arrowP;
                curList.add(temp);
            }
            
            return;
        }
        
        if(n > info[index]) {
            cur[index] = info[index] + 1;
            dfs(info, n - (info[index] + 1), index + 1, cur, curList);
        }
        
        cur[index] = 0;
        dfs(info, n, index + 1, cur, curList);
        
        return;
    }
    
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        int[] result = new int[11];
        int[] temp = new int[13];
        int maxDiff = 0;
        int minArrowP = 0;
        int idx = 0;
        List<int[]> win = new ArrayList<>();
        
        dfs(info, n, 0, result, win);
        
        if(win.size() == 0) answer = new int[]{-1};
        else {
            for(int i = 0; i < win.size(); i++) {
                temp = win.get(i);
                
                if(temp[11] > maxDiff ||
                   (temp[11] == maxDiff && temp[12] < minArrowP)) {
                    maxDiff = temp[11];
                    minArrowP = temp[12];
                    idx = i;
                }
            }
            
            answer = Arrays.copyOfRange(win.get(idx), 0, 11);
        }
        
        if(n>10) return new int[]{-2};
        return answer;
    }
}