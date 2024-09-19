class Solution {
    public int solution(int n) {
        int answer = 1;
        
        for(int i = 1;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                if((i+j)*(j-i+1)/2==n) { answer++; break; }
                else if((i+j)*(j-i+1)/2>n) break;
            }
        }
        
        return answer;
    }
}