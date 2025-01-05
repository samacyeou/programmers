class Solution {
    public int solution(int n) {
        int answer = 0;
        String temp = Integer.toBinaryString(n);
        int count = 0;
        
        for(int i = 0;i<temp.length();i++)
            if(temp.charAt(i)=='1') answer++;
        
        while(true){
            temp=Integer.toBinaryString(++n);
            
            for(int i = 0;i<temp.length();i++)
                if(temp.charAt(i)=='1') count++;
            
            if(count==answer) break;
            count=0;
        }
        
        answer=n;
        
        return answer;
    }
}