class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] test = new int[1];
        if(n == 3) return test[2];
        
        for(int i = 1;i<=n;i++){
            if(n%2==0){
                if(i%2==0)
                    answer+=Math.pow(i,2);
            } else{
                if(i%2==1)
                    answer+=i;
            }
        }
        
        return answer;
    }
}