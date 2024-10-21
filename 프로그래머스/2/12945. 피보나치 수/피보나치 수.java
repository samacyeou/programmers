class Solution {
    public int solution(int n) {
        int answer = 0;
        int a = 0;
        int b = 1;
        int temp = 0;
        int c = 1234567;
        
        if(n==0) return 0;
        else if(n==1) return 1;
        else{
            for(int i = 1;i<n;i++){
                temp=b;
                b=(a%c+b%c)%c;
                a=temp;
            }
            answer=b;
        }
        
        return answer;
    }
}