import java.util.List;
import java.util.ArrayList;

class Solution {
    public long factorial(int num) {
        long result = 1;
        for(int i = 2; i <= num; i++) result *= i;
        
        return result;
    }
    
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        boolean[] used = new boolean[n + 1];
        long facto = 0;
        int num = 0;
        
        used[0] = true;
        
        for(int i = 0; i < n; i++) {
            facto = factorial(n - 1 - i);
            num = (int)(k / facto);
            
            if(num * facto != k) num++;
            
            if(num == 0) {
                for(int j = n; j >= 0; j--) {
                    if(!used[j]) {
                        answer[i] = j;
                        used[j] = true;
                        break;
                    }
                }
            } else {
                for(int j = 0; j <= n; j++) {
                    if(!used[j]) {
                        num--;
                        if(num == 0) {
                            answer[i] = j;
                            used[j] = true;
                            break;
                        }
                    }
                }
            }
            
            k %= facto;
        }
        
        return answer;
    }
}