import java.util.ArrayList;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] temp = new int[triangle.length][];
        
        for(int i = 0;i<triangle.length;i++){
            temp[i] = new int[triangle[i].length];
        }
        
        int tp = 0;

        for(int i = 0;i<triangle.length;i++){
            for(int j = 0;j<triangle[i].length;j++){
                tp = triangle[i][j];
                if(i!=0){
                    if(j!=0 && j!=triangle[i].length-1){
                        temp[i][j] = Math.max(temp[i-1][j-1]+tp, temp[i-1][j]+tp);
                    } else if(j==0){
                        temp[i][j] = temp[i-1][j] + tp;
                    } else{
                        temp[i][j] = temp[i-1][j-1] + tp;
                    }
                } else{
                    temp[i][j] = tp;
                }
            }
        }
        
        for(int i = 0;i<temp.length;i++){
            for(int j = 0;j<temp[i].length;j++){
                answer = Math.max(answer, temp[i][j]);
            }
        }
        
        return answer;
    }
    
}