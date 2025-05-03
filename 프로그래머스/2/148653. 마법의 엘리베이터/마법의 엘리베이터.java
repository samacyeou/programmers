class Solution {
    public int solution(int storey) {
        int answer = 0;
        int rest = 0;
        
        while(storey > 0) {
            rest = storey % 10;
            
            if(rest >= 6 || rest == 5 && storey % 100 >= 50) {
                answer += 10 - rest;
                storey += 10 - rest;
            } else answer += rest;
            
            storey /= 10;
        }
        
        return answer;
    }
}