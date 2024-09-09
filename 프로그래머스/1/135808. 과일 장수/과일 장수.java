import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int[] score_cpy = new int[score.length];
        for(int i = 0; i < score.length; i++){
            score_cpy[i] = score[i];
        }

        if(score.length % 2 == 0){
            for(int i = 0; i < score_cpy.length; i++){
                score[i] = score_cpy[score.length - 1 - i];                   
            }    
        }
        else{            
            for(int i = 0; i < score.length; i++){
                if(!(i == score.length/2)){
                    score[i] = score_cpy[score.length - 1 - i];                      
                }                
            }    
        }                    
        int answer = 0;
        int init_m = m;          
        if(m == score.length){
            answer = score[score.length-1] * score.length;                
        }
        else{
            for(int i = 0; i < score.length; i++){            
                if(i == m-1){                
                    answer += score[i] * init_m;                
                    m = m + init_m;                
                }
            }                    
        }

        //만약에 한박스에 들어가는 개수 m 보다 총 사과 개수가 작다면?
        // 그러니까 m은 9이고, score = [1,2,4,5,4,4,3] 라면 

        return answer;
    }
}