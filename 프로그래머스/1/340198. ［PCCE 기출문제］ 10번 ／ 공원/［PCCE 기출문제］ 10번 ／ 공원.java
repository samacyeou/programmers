import java.util.Arrays;

class Solution {
    public int checkSpace(String[][] park, int row, int col) {
        boolean check = true;
        int maxSize = 1;
        
        for(int i = 1; row + i < park.length && col + i < park[row].length; i++) {
            loop1:
            for(int j = row; j <= row + i; j++) {
                for(int k = col; k <= col + i; k++) {
                    if(!park[j][k].equals("-1")) {
                        check = false;
                        break loop1;
                    }
                }
            }
            
            if(check) maxSize = i + 1;
            else break;
        }
        
        return maxSize;
    }
    
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int max = 0;
        
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[i].length; j++) {
                if(park[i][j].equals("-1")) {
                    max = Math.max(max, checkSpace(park, i, j));
                }
            }
        }
        
        for(int i = 0; i < mats.length; i++) {
            if(mats[i] <= max && answer < mats[i]) answer = mats[i];
        }
        
        return answer;
    }
}