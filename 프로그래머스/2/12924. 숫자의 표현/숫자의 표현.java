class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i<=n; i+=2){
            if(n%i==0){
                if((n/i)*2-1>=i){
                    answer++;
                }
                if((n/i-1)/2>=i){
                    answer++;
                }
            }
        }
        
        int test = 1;
        for(int i = 1;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                if((i+j)*(j-i+1)/2==n) { test++; break; }
                else if((i+j)*(j-i+1)/2>n) break;
            }
        }
        
        System.out.println(test);
        return test;
    }
}