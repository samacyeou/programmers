class Solution {
    public int solution(int n) {
        int answer = 0;
        double e = 0;
        boolean c = true;
        
        for(int i = 2;i<=n;i++){
            e=Math.sqrt(i);
            if(i==2||i==3){
                answer++;
                continue;
            }
            for(int j = 2;j<=e;j++){
                if(i%j==0){
                    c=false;
                    break;
                }
            }
            if(c==true)
                answer++;
            c=true;
        }
        return answer;
    }
}