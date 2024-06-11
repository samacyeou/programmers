class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int count = 0;

        for(int i = 1;i<=number;i++){
            for(int j = 1;j<=Math.sqrt(i);j++){
                if(j*j==i) count++;
                else if(i%j==0) count+=2;
            }
            if(count>limit) answer+=power;
            else answer+=count;
            count=0;
        }

        return answer;
    }
}